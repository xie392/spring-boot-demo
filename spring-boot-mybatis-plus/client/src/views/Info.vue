<script setup lang="ts">
import { InfoListApi, AddInfoApi, UpdateInfoApi, DeleteInfoApi, GetInfoSearchApi } from '@/api/info'
import { computed, reactive, ref } from 'vue'
import { Search } from '@element-plus/icons-vue'
import type { FormInstance } from 'element-plus'
import type { DataInfo } from '@/types'
import {
  validateAge,
  validateGender,
  validateMajor,
  validateName,
  VALIDATE
} from '@/utils/validate'
import { ElMessage } from 'element-plus'

/**
 * Table Data
 */
const tableData = ref<DataInfo[]>([])
const getInfoList = async () => {
  const { code, data } = await InfoListApi()
  if (code !== 200) return
  tableData.value = data
}
getInfoList()

/**
 * Search
 */
const keyword = ref<string>('')
const SearchData = computed(() => {
  return keyword.value
    ? tableData.value.filter((item) => item.name.includes(keyword.value))
    : tableData.value
})

/**
 * Dialog
 */
enum DialogType {
  ADD = '添加信息',
  EDIT = '修改信息'
}
const dialogVisible = ref<boolean>(false)
const dialogTitle = ref<DialogType>(DialogType.ADD)

const handleAdd = () => {
  dialogVisible.value = true
  dialogTitle.value = DialogType.ADD
  setFormData(null)
}

const index = ref<number>(0)
const handleEdit = (data: DataInfo, i: number) => {
  dialogVisible.value = true
  dialogTitle.value = DialogType.EDIT
  setFormData(data)
  index.value = i
}

const formRef = ref<FormInstance>()
const formData = reactive<DataInfo>({ id: '', name: '', age: 0, gender: '', major: '' })

const setFormData = (data: DataInfo | null) => {
  if (!data) {
    formData.id = ''
    formData.name = ''
    formData.age = 0
    formData.gender = ''
    formData.major = ''
  } else {
    formData.id = data.id
    formData.name = data.name
    formData.age = data.age
    formData.gender = data.gender
    formData.major = data.major
  }
}

const submitForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.validate(async (valid) => {
    if (valid) {
      if (dialogTitle.value === DialogType.ADD) {
        const { code, data } = await AddInfoApi(formData)
        if (code !== 200) return ElMessage.error('添加失败')
        tableData.value.unshift(data)
      } else {
        const { code } = await UpdateInfoApi(formData)
        if (code !== 200) return ElMessage.error('修改失败')
        tableData.value[index.value] = formData
      }
      dialogVisible.value = false
      ElMessage.success('操作成功')
    } else {
      console.log('error submit!')
      return false
    }
  })
}

const handleDelete = async (id: string) => {
  const { code } = await DeleteInfoApi(id)
  if (code !== 200) return ElMessage.error('删除失败')
  tableData.value = tableData.value.filter((item) => item.id !== id)
  ElMessage.success('删除成功')
}
</script>

<template>
  <main class="w-full min-h-[100vh] flex justify-center pt-6">
    <div class="w-[1200px]">
      <div class="flex justify-between mb-8">
        <el-button type="primary" style="width: 80px" @click="handleAdd">添加</el-button>
        <el-input
          v-model="keyword"
          style="width: 300px"
          placeholder="请输入要搜索的姓名"
          :suffix-icon="Search"
        />
      </div>
      <el-table :data="SearchData" style="width: 100%" border>
        <!-- <el-table-column prop="id" label="ID" width="180" align="center" hidden /> -->
        <el-table-column prop="name" label="姓名" width="180" align="center" />
        <el-table-column prop="age" label="年龄" width="180" align="center" />
        <el-table-column prop="gender" label="性别" width="180" align="center" />
        <el-table-column prop="major" label="专业" align="center" />
        <el-table-column label="操作" align="center">
          <template #default="scope">
            <el-button @click="handleEdit(scope.row, scope.$index)">修改</el-button>
            <el-popconfirm
              title="你确定要删除改学生吗？"
              @confirm="handleDelete(scope.row?.id)"
              confirm-button-text="确定"
              cancel-button-text="取消"
              width="200"
            >
              <template #reference>
                <el-button type="danger">删除</el-button>
              </template>
            </el-popconfirm>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </main>
  <!-- Dialog -->
  <el-dialog v-model="dialogVisible" :title="dialogTitle" width="400px">
    <el-form :model="formData" label-position="top" ref="formRef" :hide-required-asterisk="true">
      <el-form-item prop="name" :rules="[validateName]">
        <el-input v-model="formData.name" :placeholder="VALIDATE.NAME" />
      </el-form-item>
      <el-form-item prop="age" :rules="[validateAge]">
        <el-input v-model="formData.age" type="number" :placeholder="VALIDATE.AGE" />
      </el-form-item>
      <el-form-item prop="gender" :rules="[validateGender]">
        <el-input v-model="formData.gender" :placeholder="VALIDATE.GENDER" />
      </el-form-item>
      <el-form-item prop="major" :rules="[validateMajor]">
        <el-input v-model="formData.major" :placeholder="VALIDATE.MAJOR" />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="submitForm(formRef)">
          {{ dialogTitle === DialogType.ADD ? '添加' : '保存' }}
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>

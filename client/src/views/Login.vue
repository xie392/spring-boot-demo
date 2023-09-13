<script setup lang="ts">
import { reactive, ref } from 'vue'
import type { FormInstance } from 'element-plus'
import { LoginApi } from '@/api/user'
import { setCookie } from '@/utils/auth'
import { useRouter } from 'vue-router'
import { ElMessage } from 'element-plus'
import { validateName, validatePassword } from '@/utils/validate'

const router = useRouter()
const formRef = ref<FormInstance>()
const formData = reactive({ name: '', password: '' })
const submitForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.validate(async (valid) => {
    if (valid) {
      const { code, data } = await LoginApi(formData)
      if (code === 200) {
        setCookie('token', data.token)
        ElMessage.success('登录成功')
        setTimeout(() => {
          router.push({ path: '/' })
        }, 1000)
      } else {
        ElMessage.error('登录失败')
      }
    } else {
      console.log('error submit!')
      return false
    }
  })
}
</script>

<template>
  <div class="w-full h-screen flex items-center justify-center">
    <div class="w-[350px]">
      <h2 class="font-bold text-xl pb-6 text-center">Hello Login</h2>
      <el-form :model="formData" label-position="top" ref="formRef" :hide-required-asterisk="true">
        <el-form-item label="用户名：" prop="name" :rules="[validateName]">
          <el-input v-model="formData.name" />
        </el-form-item>
        <el-form-item label="密码：" prop="password" :rules="[validatePassword]">
          <el-input v-model="formData.password" type="password" show-password />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" style="width: 100%" @click="submitForm(formRef)"
            >登录</el-button
          >
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<style scoped></style>

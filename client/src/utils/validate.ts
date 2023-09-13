export const Validate = (message: string, required?: boolean, trigger?: string | string[]) => ({
  required: required ?? true,
  message,
  trigger: trigger ?? 'blur'
})

export enum VALIDATE {
  NAME = '请输入姓名',
  AGE = '请输入年龄',
  GENDER = '请选择性别',
  MAJOR = '请选择专业',
  ID = '请输入学号',
  PASSWORD = '请输入密码'
}

export const validateName = Validate(VALIDATE.NAME)
export const validateAge = Validate(VALIDATE.AGE)
export const validateGender = Validate(VALIDATE.GENDER)
export const validateMajor = Validate(VALIDATE.MAJOR)
export const validateId = Validate(VALIDATE.ID)
export const validatePassword = Validate(VALIDATE.PASSWORD)

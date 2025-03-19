package com.ntougnsslab.l2homework

class BMICalculator {
    fun analyzeBMI(userInfo: UserInfo?): String/* TODO 補上回傳類型 */ {
        /* TODO 要做null判斷，回傳錯誤 */
        if (userInfo == null || userInfo.weight <= 0 || userInfo.height <= 0) {
            return "ERROR,Please provide correct Information!!"
        }
        /* TODO 根據userInfo內的資料計算出BMI值 */
        val heightInMeters = userInfo.height / 100.0
        val weight = userInfo.weight
        val bmi = weight / (heightInMeters * heightInMeters)
        var bmiRes = ""
        /* TODO 根據BMI值判斷出BMI結果，且BMI結果要根據男女還有年齡判斷 */
        if (userInfo.gender) {
            bmiRes = when {
            bmi < 18.5 -> "過輕"
            bmi < 24.9 -> "正常"
            bmi < 29.9 -> "過重"
            else -> "肥胖"
        }}
        else{
            bmiRes = when {
                bmi < 19 -> "過輕"
                bmi < 26 -> "正常"
                bmi < 32 -> "過重"
                else -> "肥胖"
        }}
        /* TODO 把BMI值還有結果用Kotlin的format組合 */
        return "Your BMI is %.2f, gender = ${userInfo.gender}, health status = $bmiRes".format(bmi)
    }
}

//}
//class BMICalculator {
//    fun analyzeBMI(userInfo: UserInfo?): String {
//        /* TODO 要做null判斷，回傳錯誤 */
//
//        if (userInfo == null) return "TODO: 回傳錯誤"
//
//
//        /* TODO 根據userInfo內的資料計算出BMI值 */
//        val bmi =userInfo.weight / ((userInfo.height / 100) * (userInfo.height / 100))
//        /* TODO 根據BMI值判斷出BMI結果，且BMI結果要根據男女還有年齡判斷 */
//        var bmiRes = ""
//
//        if (userInfo.gender) { // 男
//            if (userInfo.age < 18) {
//                if (bmi>30){
//                    bmiRes = "過重"
//                }
//
//                else if (bmi<18){
//                    bmiRes = "過輕"
//                }
//
//                else {
//                    bmiRes = "正常"
//                }
//
//
//            }
//
//            else{
//                if (bmi>30){
//                    bmiRes = "過重"
//                }
//
//                else if (bmi<18){
//                    bmiRes = "過輕"
//                }
//
//                else {
//                    bmiRes = "正常"
//                }
//            }
//
//        }
//
//        else{ // 女
//            if (userInfo.age < 18) {
//                if (bmi>30){
//                    bmiRes = "過重"
//                }
//
//                else if (bmi<18){
//                    bmiRes = "過輕"
//                }
//
//                else {
//                    bmiRes = "正常"
//                }
//
//
//            }
//
//            else{
//                if (bmi>32){
//                    bmiRes = "過重"
//                }
//
//                else if (bmi<16){
//                    bmiRes = "過輕"
//                }
//
//                else {
//                    bmiRes = "正常"
//                }
//            }
//
//        }
//
//        //var bmiRes = "TODO: BMI結果"
//        /* TODO 把BMI值還有結果用Kotlin的format組合 */
//
//        if(userInfo.gender){
//            return "男Bmi = %.2f, %s".format(bmi, bmiRes)
//        }
//        else{
//            return "女Bmi = %.2f, %s".format(bmi, bmiRes)
//        }
//
//    }
//}
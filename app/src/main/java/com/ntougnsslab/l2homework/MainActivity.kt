package com.ntougnsslab.l2homework

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ntougnsslab.l2homework.ui.theme.L2HomeWorkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // onCreate() 是程式進入點

        val bmiCalculator: BMICalculator = BMICalculator() /* TODO 在這宣告實例 */

        super.onCreate(savedInstanceState)
        setContent { // setContent() 是設定畫面的方法 (Compose)
            var bmiResult by remember {
                mutableStateOf("")
            }
            L2HomeWorkTheme { // L2HomeWorkTheme 是自訂的主題 (Compose)，名字可以自己取 但要和 Theme.kt 中的一樣
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    BMICalculator(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            val res = bmiCalculator.analyzeBMI(it)
                            bmiResult = res
                            Toast.makeText(
                                this@MainActivity,
                                "BMI: $res",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                    Text(text = "BMI結果: $bmiResult")
                }
            }
        }
    }
}

@Composable
fun BMICalculator(
    modifier: Modifier = Modifier,
    onClick: (UserInfo?) -> Unit = {}
) {
    var userInfo by remember {
        mutableStateOf(UserInfo())
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "BMI 計算機")
        OutlinedTextField(
            label = { Text(text = "姓名") },
            value = userInfo.name,
            onValueChange = {
                userInfo = userInfo.copy(
                    name = it
                )
            },
            trailingIcon = {
                Switch(
                    modifier = Modifier.padding(end = 8.dp),
                    checked = userInfo.gender,
                    onCheckedChange = {
                        userInfo = userInfo.copy(
                            gender = it
                        )
                    },
                    thumbContent = {
                        if (userInfo.gender) Icon(Icons.Default.Male, contentDescription = "Male")
                        else Icon(Icons.Default.Female, contentDescription = "Female")
                    },
                )
            }
        )
        OutlinedTextField(
            label = { Text(text = "年齡") },
            value = userInfo.age.toString(),
            onValueChange = {
                if (it.isEmpty()) return@OutlinedTextField
                userInfo = userInfo.copy(
                    age = it.toInt()
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            label = { Text(text = "體重") },
            value = userInfo.weight.toString(),
            onValueChange = {
                if (it.isEmpty()) return@OutlinedTextField
                userInfo = userInfo.copy(
                    weight = it.toDouble()
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            label = { Text(text = "身高cm") },
            value = userInfo.height.toString(),
            onValueChange = {
                if (it.isEmpty()) return@OutlinedTextField
                userInfo = userInfo.copy(
                    height = it.toDouble()
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(
            onClick = {
                if(userInfo.name.isEmpty()) onClick(userInfo)
            }
        ) {
            Text("分析")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    L2HomeWorkTheme {
        BMICalculator(
            Modifier.fillMaxSize()
        )
    }
}
package br.com.fundatec.fundatecheroti22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private var test: TestEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        test = TestEntity(
            label1 = "Usuário",
            label3 = 18
        )

        val dto:TestDto? = test?.run {
            mapper(value1 = label1, value2 = label2)
        }
        dto?.label3


        val dto2:TestEntity? = test?.apply {
            TestEntity(label1 = label1, label2 = label2, label3 = 29)
            copy( label3 = 29)
        }
    }

    private fun mapper(value1: String, value2: String?): TestDto {
        return TestDto(
            label1 = value1,
            label2 = value2.orEmpty(),
        )
    }

}

data class TestDto(
    val label1: String,
    val label2: String,
    val label3: Int = 0,
)

data class TestEntity(
    val label1: String,
    val label2: String? = null,
    val label3: Int = 0,
)
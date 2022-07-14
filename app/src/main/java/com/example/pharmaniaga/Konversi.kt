package com.example.pharmaniaga


object Konversi {
    private val one = arrayOf(
        "", "satu ", "dua ", "tiga ", "empat ",
        "lima ", "enam ", "tujuh ", "delapan ",
        "sembilan ", "sepuluh ", "sebelas ", "duabelas ",
        "tigabelas ", "empatbelas ", "limabelas ",
        "enambelas ", "tujuhbelas ", "delapanbelas ",
        "sembilanbelas "
    )
    private val ten = arrayOf(
        "", "", "duapuluh ", "tigapuluh ", "empatpuluh ",
        "limapuluh ", "enampuluh ", "tujuhpuluh ", "delapanpuluh ",
        "sembilanpuluh "
    )

    private fun numToWords(n: Int, s: String?): String? {
        var str: String? = ""
        str += if (n > 19) {
            ten[n / 10] + one[n % 10]
        } else {
            one[n]
        }
        if (n != 0) {
            str += s
        }
        return str
    }


    fun convertToWords(n: Long): String? {
        var result: String? = ""
        result += numToWords((n / 1000 % 100).toInt(), "ribu ")

        result += numToWords((n / 100 % 10).toInt(), "ratus ")
        if (n > 100 && n % 100 > 0) {
            result += ""
        }
        result += numToWords((n % 100).toInt(), "")
        return result
    }
}
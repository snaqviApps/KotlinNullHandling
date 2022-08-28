package ghar.learning.with.kotlin


class App {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {

            println("Kotlin-main")
            val mNullable: Meeting? = null              // nullable (safe-call)
            val mSafe = Meeting()                       // non-nullable

            closeMeetingNonNull(mSafe)
        }

        private fun closeMeetingNonNull(m: Meeting): Boolean {

            /** safe-call */
            return if (m.canClose) m.close()
            else false

            /** non-null assertion, will throw exception if object is null */
//            return if(m!!.canClose) m.close()
//            else false
        }
    }

}

class Meeting() {
    var canClose: Boolean = false
    lateinit var address : Address      // ONLY to be initialized later

    fun initAddress(addressIn : Address) {
        address = addressIn              /** initialization is a-must for a property that is 'lateinit */
    }
    fun close(): Boolean {
        return true
    }
}

class Address{

}

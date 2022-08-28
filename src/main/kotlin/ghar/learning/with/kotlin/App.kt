package ghar.learning.with.kotlin


class App {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println("Kotlin-main")
            val mNullable: Meeting? = null                  // nullable (safe-call)
            val mSafe = Meeting()                           // non-nullable

            /** safe call using let{} call
             * only block in 'let' will be executed
             * iff mNullable is Non-Null
             */
           mNullable?.let { meet ->
               closeMeetingNonNull(meet)
           }

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

class Meeting {
    var canClose: Boolean = false
    fun close(): Boolean {
        return true
    }
}
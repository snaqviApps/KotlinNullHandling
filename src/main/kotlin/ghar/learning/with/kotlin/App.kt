package ghar.learning.with.kotlin


class App {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println("Kotlin-main")
            val mNullable: Meeting? = null                  // nullable (safe-call)
            val mSafe = Meeting()                           // non-nullable
            val mNullCoalescing = mNullable ?: Meeting()    // ELVIS-operator (Coalescing)
            val iSaveable: ISaveable = object : ISaveable {
                override fun save() {
                    println("ISaveable anonymous implementation")
                }
            }
            mSafe.save(iSaveable)

            println("nullable meeting returns: ${closeMeeting(mNullable)}")
            println("Null-Coalescing meeting always non-null: ${closeMeeting(mNullCoalescing)}")
            println("null-safe instance-input returns: ${closeMeeting(mSafe)}")
        }

        private fun closeMeeting(m: Meeting?): Boolean {

            /** safe-call */
            return if (m?.canClose == false) m.close(true)
            else false

            /** non-null assertion, will throw exception if object is null */
//            return if(m!!.canClose) m.close()
//            else false
        }
    }

}

class Meeting {
    var canClose: Boolean = false
    fun close(canClose: Boolean): Boolean {
        return true
    }

    /** @o is assigned null if not of type ISaveeable */
    fun save(o: Any) {
        val saveable: ISaveable? = o as? ISaveable    // save-cast

        /** only called if 'o' is of type-ISaveable */
        saveable?.save()
    }

}
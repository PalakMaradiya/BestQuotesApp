package com.example.thebestquetosapp.Database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import android.util.Log
import com.example.thebestquetosapp.ModalClass.FavouriteQuoteModelclass
import com.example.thebestquetosapp.ModalClass.CategoryModalClass
import com.example.thebestquetosapp.ModalClass.QuotesModalClass
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

class MyDatabase(context: Context) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    private val mDataBase: SQLiteDatabase? = null
    private var mNeedUpdate = false
    private val mContext: Context

    private fun copyDataBase() {
        if (!checkDataBase()) {
            this.readableDatabase
            close()
            try {
                copyDBFile()
            } catch (mIOException: IOException) {
                throw Error("ErrorCopyingDataBase")
            }
        }
    }

    private fun checkDataBase(): Boolean {
        val dbFile = File(DB_PATH + DB_NAME)
        return dbFile.exists()
    }


    @Throws(IOException::class)
    private fun copyDBFile() {
        val mInput = mContext.assets.open(DB_NAME)
        val mOutput: OutputStream = FileOutputStream(DB_PATH + DB_NAME)
        val mBuffer = ByteArray(1024)
        var mLength: Int
        while (mInput.read(mBuffer).also { mLength = it } > 0) mOutput.write(mBuffer, 0, mLength)
        mOutput.flush()
        mOutput.close()
        mInput.close()
    }

    override fun onCreate(db: SQLiteDatabase) {}
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if (newVersion > oldVersion) mNeedUpdate = true
    }


    @Throws(IOException::class)
    fun updateDataBase() {
        if (mNeedUpdate) {
            val dbFile = File(DB_PATH + DB_NAME)
            if (dbFile.exists()) dbFile.delete()
            copyDataBase()
            mNeedUpdate = false
        }
    }

    @Synchronized
    override fun close() {
        mDataBase?.close()
        super.close()
    }


    fun CategoryDisplay() : ArrayList<CategoryModalClass>
    {
        var read = readableDatabase
        var Displaylist = ArrayList<CategoryModalClass>()
        var query = "select * from CategoryTable"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()
        do {

            var id = cursor.getInt(0)
            var name = cursor.getString(1)

            Displaylist .add(CategoryModalClass(id,name))

        }while (cursor.moveToNext())

        return Displaylist

    }




    fun AttitudeQuotesDisplay() : ArrayList<QuotesModalClass>
    {
        var read = readableDatabase
        var Displaylist = ArrayList<QuotesModalClass>()
        var query = "select * from QuotesTable where Category_id = 1"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()

        do {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var like = cursor.getInt(2)

            Displaylist.add(QuotesModalClass(id,name,like))
        }while (cursor.moveToNext())

        return Displaylist

    }



    fun AwesomeQuotesDisplay() : ArrayList<QuotesModalClass>
    {
        var read = readableDatabase
        var Displaylist = ArrayList<QuotesModalClass>()
        var query = "select * from QuotesTable where Category_id = 2"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()

        do {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var like = cursor.getInt(2)

            Displaylist.add(QuotesModalClass(id,name,like))
        }while (cursor.moveToNext())

        return Displaylist

    }

    fun CoolQuotesDisplay() : ArrayList<QuotesModalClass>
    {
        var read = readableDatabase
        var Displaylist = ArrayList<QuotesModalClass>()
        var query = "select * from QuotesTable where Category_id = 3"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()

        do {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var like = cursor.getInt(2)

            Displaylist.add(QuotesModalClass(id,name,like))
        }while (cursor.moveToNext())

        return Displaylist

    }

    fun FriendsQuotesDisplay() : ArrayList<QuotesModalClass>
    {
        var read = readableDatabase
        var Displaylist = ArrayList<QuotesModalClass>()
        var query = "select * from QuotesTable where Category_id = 4"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()

        do {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var like = cursor.getInt(2)

            Displaylist.add(QuotesModalClass(id,name,like))
        }while (cursor.moveToNext())

        return Displaylist

    }

    fun HappinessQuotesDisplay() : ArrayList<QuotesModalClass>
    {
        var read = readableDatabase
        var Displaylist = ArrayList<QuotesModalClass>()
        var query = "select * from QuotesTable where Category_id = 5"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()

        do {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var like = cursor.getInt(2)

            Displaylist.add(QuotesModalClass(id,name,like))
        }while (cursor.moveToNext())

        return Displaylist

    }


    fun HurtQuotesDisplay() : ArrayList<QuotesModalClass>
    {
        var read = readableDatabase
        var Displaylist = ArrayList<QuotesModalClass>()
        var query = "select * from QuotesTable where Category_id = 6"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()

        do {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var like = cursor.getInt(2)

            Displaylist.add(QuotesModalClass(id,name,like))
        }while (cursor.moveToNext())

        return Displaylist

    }



    fun InspirationalQuotesDisplay() : ArrayList<QuotesModalClass>
    {
        var read = readableDatabase
        var Displaylist = ArrayList<QuotesModalClass>()
        var query = "select * from QuotesTable where Category_id = 7"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()

        do {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var like = cursor.getInt(2)

            Displaylist.add(QuotesModalClass(id,name,like))
        }while (cursor.moveToNext())

        return Displaylist

    }


    fun LifeQuotesDisplay() : ArrayList<QuotesModalClass>
    {
        var read = readableDatabase
        var Displaylist = ArrayList<QuotesModalClass>()
        var query = "select * from QuotesTable where Category_id = 8"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()

        do {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var like = cursor.getInt(2)

            Displaylist.add(QuotesModalClass(id,name,like))
        }while (cursor.moveToNext())

        return Displaylist

    }


    fun MotivationalQuotesDisplay() : ArrayList<QuotesModalClass>
    {
        var read = readableDatabase
        var Displaylist = ArrayList<QuotesModalClass>()
        var query = "select * from QuotesTable where Category_id = 9"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()

        do {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var like = cursor.getInt(2)

            Displaylist.add(QuotesModalClass(id,name,like))
        }while (cursor.moveToNext())

        return Displaylist

    }


    fun MovingOnQuotesDisplay() : ArrayList<QuotesModalClass>
    {
        var read = readableDatabase
        var Displaylist = ArrayList<QuotesModalClass>()
        var query = "select * from QuotesTable where Category_id = 10"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()

        do {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var like = cursor.getInt(2)

            Displaylist.add(QuotesModalClass(id,name,like))
        }while (cursor.moveToNext())

        return Displaylist

    }



    fun SadQuotesDisplay() : ArrayList<QuotesModalClass>
    {
        var read = readableDatabase
        var Displaylist = ArrayList<QuotesModalClass>()
        var query = "select * from QuotesTable where Category_id = 11"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()

        do {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var like = cursor.getInt(2)

            Displaylist.add(QuotesModalClass(id,name,like))
        }while (cursor.moveToNext())

        return Displaylist

    }


    fun SelfLoveQuotesDisplay() : ArrayList<QuotesModalClass>
    {
        var read = readableDatabase
        var Displaylist = ArrayList<QuotesModalClass>()
        var query = "select * from QuotesTable where Category_id = 12"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()

        do {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var like = cursor.getInt(2)

            Displaylist.add(QuotesModalClass(id,name,like))
        }while (cursor.moveToNext())

        return Displaylist

    }


    fun SingleQuotesDisplay() : ArrayList<QuotesModalClass>
    {
        var read = readableDatabase
        var Displaylist = ArrayList<QuotesModalClass>()
        var query = "select * from QuotesTable where Category_id = 13"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()

        do {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var like = cursor.getInt(2)

            Displaylist.add(QuotesModalClass(id,name,like))
        }while (cursor.moveToNext())

        return Displaylist

    }


    fun SmileQuotesDisplay() : ArrayList<QuotesModalClass>
    {
        var read = readableDatabase
        var Displaylist = ArrayList<QuotesModalClass>()
        var query = "select * from QuotesTable where Category_id = 14"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()

        do {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var like = cursor.getInt(2)

            Displaylist.add(QuotesModalClass(id,name,like))
        }while (cursor.moveToNext())

        return Displaylist

    }


    fun SuccessQuotesDisplay() : ArrayList<QuotesModalClass>
    {
        var read = readableDatabase
        var Displaylist = ArrayList<QuotesModalClass>()
        var query = "select * from QuotesTable where Category_id = 15"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()

        do {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var like = cursor.getInt(2)

            Displaylist.add(QuotesModalClass(id,name,like))
        }while (cursor.moveToNext())

        return Displaylist

    }


    fun TrueQuotesDisplay() : ArrayList<QuotesModalClass>
    {
        var read = readableDatabase
        var Displaylist = ArrayList<QuotesModalClass>()
        var query = "select * from QuotesTable where Category_id = 16"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()

        do {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var like = cursor.getInt(2)

            Displaylist.add(QuotesModalClass(id,name,like))
        }while (cursor.moveToNext())

        return Displaylist

    }


    fun LoveQuotesDisplay() : ArrayList<QuotesModalClass>
    {
        var read = readableDatabase
        var Displaylist = ArrayList<QuotesModalClass>()
        var query = "select * from QuotesTable where Category_id = 17"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()

        do {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var like = cursor.getInt(2)

            Displaylist.add(QuotesModalClass(id,name,like))
        }while (cursor.moveToNext())

        return Displaylist

    }


    fun AngryQuotesDisplay() : ArrayList<QuotesModalClass>
    {
        var read = readableDatabase
        var Displaylist = ArrayList<QuotesModalClass>()
        var query = "select * from QuotesTable where Category_id = 18"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()

        do {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var like = cursor.getInt(2)

            Displaylist.add(QuotesModalClass(id,name,like))
        }while (cursor.moveToNext())

        return Displaylist

    }

    fun AloneQuotesDisplay() : ArrayList<QuotesModalClass>
    {
        var read = readableDatabase
        var Displaylist = ArrayList<QuotesModalClass>()
        var query = "select * from QuotesTable where Category_id = 19"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()

        do {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var like = cursor.getInt(2)

            Displaylist.add(QuotesModalClass(id,name,like))
        }while (cursor.moveToNext())

        return Displaylist

    }

    fun UpdateFavouriteQuote(status: Int, id: Int)
    {
        var write = writableDatabase
        Log.e("TAG", "UpdateFavouriteQuote: "+status+"   id    "+id )
        val strSQL = "UPDATE QuotesTable SET Favourite=$status WHERE Id = $id"
        write.execSQL(strSQL)

    }


    fun FavouriteQuoteDisplay(): ArrayList<FavouriteQuoteModelclass>
    {
        var read = readableDatabase
        var displayquote = ArrayList<FavouriteQuoteModelclass>()
        var query = "select * from QuotesTable where Favourite = 100"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()
        do {
            var id = cursor.getInt(0)
            var Quotes = cursor.getString(1)
            var status = cursor.getInt(2)
            displayquote.add(FavouriteQuoteModelclass(id,Quotes,status))
        }while (cursor.moveToNext())
        return displayquote
    }




    companion object {
        private const val TAG = "MyDatabase"
        private const val DB_NAME = "catDatabse.db"
        private var DB_PATH = ""
        private const val DB_VERSION = 1
    }

    init {
        if (Build.VERSION.SDK_INT >= 17) DB_PATH =
            context.applicationInfo.dataDir + "/databases/" else DB_PATH =
            "/data/data/" + context.packageName + "/databases/"
        mContext = context
        copyDataBase()
        this.readableDatabase
    }
}
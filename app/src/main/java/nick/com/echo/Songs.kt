package nick.com.echo

import android.os.Parcel
import android.os.Parcelable


/**
 * Created by nick on 7/19/2018.
 */


class Songs(var songID: Long, var songTitle: String, var artist: String, var songData: String?, var dateAdded: Long) : Parcelable {
    override fun writeToParcel(p0: Parcel?, p1: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    var msongDateAdded: Long = 0

    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readLong()) {
        msongDateAdded = parcel.readLong()
    }


    init {
        this.msongDateAdded = dateAdded
    }


    object Statified {
        var nameComparator: Comparator<Songs> = Comparator<Songs> { song1, song2 ->
            val nameOne = song1.songTitle.toUpperCase()
            val nameTwo = song2.songTitle.toUpperCase()
            //ascending order
            nameOne.compareTo(nameTwo)
        }

        var dateComparator: Comparator<Songs> = Comparator<Songs> { song1, song2 ->
            val dateOne = java.lang.Double.valueOf(song1.msongDateAdded.toDouble())
            val dateTwo = java.lang.Double.valueOf(song2.msongDateAdded.toDouble())

            //recent order order
            dateTwo.compareTo(dateOne)
        }
    }

    companion object CREATOR : Parcelable.Creator<Songs> {
        override fun createFromParcel(parcel: Parcel): Songs {
            return Songs(parcel)
        }

        override fun newArray(size: Int): Array<Songs?> {
            return arrayOfNulls(size)
        }
    }

}
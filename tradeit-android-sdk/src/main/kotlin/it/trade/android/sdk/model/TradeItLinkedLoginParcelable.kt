package it.trade.android.sdk.model

import android.os.Parcel
import android.os.Parcelable
import it.trade.model.reponse.TradeItOAuthAccessTokenResponse
import it.trade.model.request.TradeItLinkedLogin
import it.trade.model.request.TradeItOAuthAccessTokenRequest


class TradeItLinkedLoginParcelable : TradeItLinkedLogin, Parcelable {
    constructor(broker: String, userId: String, userToken: String) : super(broker, userId, userToken) {}

    constructor(
        oAuthAccessTokenRequest: TradeItOAuthAccessTokenRequest,
        oAuthAccessTokenResponse: TradeItOAuthAccessTokenResponse
    ) : super(oAuthAccessTokenRequest, oAuthAccessTokenResponse) {}

    constructor(linkedLogin: TradeItLinkedLogin) {
        this.broker = linkedLogin.broker
        this.userId = linkedLogin.userId
        this.userToken = linkedLogin.userToken
        this.label = linkedLogin.label
    }

    fun getUserId(): String {
        return userId
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        val that = other as TradeItLinkedLoginParcelable?

        return userId == that!!.userId

    }

    override fun hashCode(): Int {
        return userId.hashCode()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(this.label)
        dest.writeString(this.broker)
        dest.writeString(this.userToken)
        dest.writeString(this.userId)
    }

    protected constructor(`in`: Parcel) {
        this.label = `in`.readString()
        this.broker = `in`.readString()
        this.userToken = `in`.readString()
        this.userId = `in`.readString()
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<TradeItLinkedLoginParcelable> = object : Parcelable.Creator<TradeItLinkedLoginParcelable> {
            override fun createFromParcel(source: Parcel): TradeItLinkedLoginParcelable {
                return TradeItLinkedLoginParcelable(source)
            }

            override fun newArray(size: Int): Array<TradeItLinkedLoginParcelable?> {
                return arrayOfNulls(size)
            }
        }
    }
}

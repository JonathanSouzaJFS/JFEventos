package br.com.jfeventos.utils

import android.content.Context
import android.content.DialogInterface
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AlertDialog
import br.com.jfeventos.R

fun hasInternet(context: Context?): Boolean {
    val connectivityManager =
        context?.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager

    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
        val network = connectivityManager?.activeNetwork
        val connection = connectivityManager?.getNetworkCapabilities(network)
        return connection != null && (
                connection.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                        connection.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
    } else {
        val activeNetwork = connectivityManager?.activeNetworkInfo
        if (activeNetwork != null) {
            return (activeNetwork.type == ConnectivityManager.TYPE_WIFI ||
                    activeNetwork.type == ConnectivityManager.TYPE_MOBILE)
        }
        return false
    }
}

fun AlertDialog.Builder.show(
    title: String,
    contentDescription: String = "",
    positiveButtonDescription: String? = null,
    positiveButtonAction: (DialogInterface?) -> Unit = {},
    negativeButtonDescription: String? = null,
    negativeButtonAction: (DialogInterface?) -> Unit = {},
    isCancelable: Boolean = true
): AlertDialog {
    setTitle(context.getString(R.string.ops_title))
        .setCancelable(isCancelable)
        .setTitle(title)
        .setMessage(contentDescription)
    positiveButtonDescription?.let { description ->
        setPositiveButton(description) { dialog, _ -> positiveButtonAction(dialog) }
    }

    negativeButtonDescription?.let { description ->
        setNegativeButton(description) { dialog, _ -> negativeButtonAction(dialog) }
    }
    return show()
}


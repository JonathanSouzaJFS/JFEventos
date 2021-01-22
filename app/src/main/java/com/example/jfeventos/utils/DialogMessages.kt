package com.example.jfeventos.utils

import android.content.Context
import android.content.DialogInterface
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.example.jfeventos.R


fun showError(context: Context, message: String?) {
    try {
        AlertDialog.Builder(context, R.style.DialogTheme).show(
            title = context.getString(R.string.ops_title),
            contentDescription = message ?: "",
            positiveButtonDescription = context.getString(R.string.ok)
        )
    } catch (ignored: Exception) {
        Log.i("", ignored.message ?: "Falha em mostrar o AlertDialog.")
    }
}

fun showNetworkError(context: Context, positiveButtonAction: (DialogInterface?) -> Unit = {}) {
    try {
        AlertDialog.Builder(context, R.style.DialogTheme)
            .show(
                title = context.getString(R.string.ops_title),
                contentDescription = context.getString(R.string.error_connection),
                positiveButtonDescription = context.getString(R.string.try_again),
                positiveButtonAction = positiveButtonAction,
                negativeButtonDescription = context.getString(R.string.cancel),
                negativeButtonAction = { dialog -> dialog?.dismiss() }
            )
    } catch (ignored: Exception) {
        Log.i("", ignored.message ?: "Falha em mostrar o AlertDialog.")
    }
}
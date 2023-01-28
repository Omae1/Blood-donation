package com.wil.blooddonationapp

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ExitDialog: DialogFragment (){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder
            .setIcon(android.R.drawable.ic_menu_close_clear_cancel)
            .setTitle("Exit?")
            .setMessage("Do you want to exit")
            .setPositiveButton("ok") { _, _ -> activity?.finishAffinity() }
            .setNegativeButton("cancel") { _, _ -> dialog?.dismiss() }
        return builder.create()
    }

    }
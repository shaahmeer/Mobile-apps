package com.mirea.nawab.dialougebox;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Здравствуй МИРЭА!")
                .setMessage("Успех близок?")
                .setIcon(R.mipmap.ic_launcher_round)
                .setPositiveButton("Иду дальше", (dialog, id) -> {
                    ((MainActivity)getActivity()).onOkClicked();
                    dialog.cancel();
                })
                .setNeutralButton("На паузе",
                        (dialog, id) -> {
                            ((MainActivity)getActivity()).onNeutralClicked();
                            dialog.cancel();
                        })
                .setNegativeButton("Нет",
                        (dialog, id) -> {
                            ((MainActivity)getActivity()).onCancelClicked();
                            dialog.cancel();
                        });
        return builder.create();
    }
}
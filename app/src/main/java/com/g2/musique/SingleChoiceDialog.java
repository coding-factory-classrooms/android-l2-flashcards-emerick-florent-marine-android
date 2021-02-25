package com.g2.musique;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.io.IOException;

/**
 * @class SingleChoiceDialog for dialog box
 */
public class SingleChoiceDialog extends DialogFragment {
    int position = 0;

    /**
     * @interface for use button
     */
    public interface SingleChoiceListener {
        void onPositiveButtonClicked(String[] list, int position) throws IOException;
        void onNegativeButtonClicked();
    }

    SingleChoiceListener listener;

    /**
     *
     * Generate context of dialog
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (SingleChoiceListener) context;
        }catch (Exception e) {
            throw new ClassCastException(getActivity().toString() + " Veuillez choisir un niveau " +
                    "de difficulté");
        }
    }

    /**
     *
     * @return choice dialog
     */
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final String[] list = getActivity().getResources().getStringArray(R.array.choice_item);
        builder.setTitle("Choisissez un niveau de difficulté")
                .setSingleChoiceItems(list, position, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        position = i;
                    }
                })
                .setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            listener.onPositiveButtonClicked(list, position);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                })
                .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listener.onNegativeButtonClicked();
                    }
                });
        return builder.create();
    }
}

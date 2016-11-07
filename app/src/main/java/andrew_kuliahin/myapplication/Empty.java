package andrew_kuliahin.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;

/**
 * Created by Админ on 31.10.2016.
 */

public class Empty {
    public Empty(AlertDialog.Builder builder){
        builder.setTitle("Empty Field")
                .setMessage("Пожалуйста заполните поле ввода")
                .setCancelable(false)
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}

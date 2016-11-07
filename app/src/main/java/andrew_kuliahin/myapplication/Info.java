package andrew_kuliahin.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;

/**
 * Created by Админ on 09.10.2016.
 */

public class Info {
    public Info(AlertDialog.Builder builder){
        builder.setTitle("About")
                .setMessage("Приложение Journal\nКулягин Андрей\nНАУ \"ХАИ\" 2016")
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

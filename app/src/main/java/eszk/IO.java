package eszk;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;

import java.io.IOException;
import java.io.InputStream;

import blacklinden.intentgyak.R;



/**
 * Created by Vitya on 2017. 11. 20..
 */

public class IO {

            public String io(Context c,String txt){
                try{
                    InputStream is = c.getAssets().open(txt);
                    int méret = is.available();
                    byte[] buffer = new byte[méret];
                    final int read = is.read(buffer);
                    is.close();
                    return new String(buffer);
                }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public Spanned io_html(String html){

        return Html.fromHtml(html,1);
    }
}

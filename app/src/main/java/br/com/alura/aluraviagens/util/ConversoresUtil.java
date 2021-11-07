package br.com.alura.aluraviagens.util;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConversoresUtil {


    public static Drawable devolveDrawable(Context context, String imagem) {

        int identificadorDraw = context.getResources().getIdentifier(imagem, "drawable", context.getPackageName());
        return context.getResources().getDrawable(identificadorDraw);

    }

    public static String corrigeDias(Integer qtdeDias) {

        if (qtdeDias == 1) {
            return qtdeDias + " dia";
        } else {
            return qtdeDias + " dias";
        }

    }

    @NonNull
    public static String periodoEmTexto(int dias) {

        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(5, dias);
        SimpleDateFormat dataBrasileira = new SimpleDateFormat("dd/MM");
        String dataIdaBR = dataBrasileira.format(dataIda.getTime());
        String dataVoltaBR = dataBrasileira.format(dataVolta.getTime());
        return "De " + dataIdaBR + " a " + dataVoltaBR + " de " + dataVolta.get(Calendar.YEAR);
    }


}

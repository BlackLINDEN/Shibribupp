package eszk;

/**
 * Created by Vitya on 2017. 12. 16..
 */

public class Számológép {

    public static String errőlerre;
    public static String érték;



enum szatVáltó{

        PPM7(1.4f,0.7f,700,"ppm7"),PPM5(0.7143f,0.5f,500,"ppm5")
    ,ECMS(0.0014286f,0.002f,0.001f,"ecms"),ECUS(1.4286f,2,1000,"ecus");

        private float váltó1,váltó2,váltó3;
        private String azonosító;

        szatVáltó(float váltószám,float váltó2, float váltó3,String azonosító){
            this.váltó1=váltószám;
            this.váltó2=váltó2;
            this.váltó3=váltó3;

            this.azonosító=azonosító;
        }

        public static szatVáltó kivál(String azonosító){
            for(szatVáltó sz:szatVáltó.values()){
                if(sz.azonosító.equals(azonosító))
                return sz;
            }
            return null;
        }

        public float[] válts(float a){
            return new float[]{a*váltó1,a*váltó2,a*váltó3};
        }
}





    private static String határozó(){
    String a;
        switch (errőlerre){
            case "Convert PPM.7": a="ppm7";
            break;
            case "Convert PPM.5": a="ppm5";
            break;
            case"Convert EC/mS": a="ecms";
            break;
            case "Convert EC uS": a="ecus";
            break;
            default:a="error";
        }
        return a;
    }



    public static String fogalmazó(){
    float a = Float.parseFloat(érték);
    StringBuilder sb = new StringBuilder();
        for(int i=0;i<3;i++)
                sb.append(szatVáltó.kivál(határozó()).válts(a)[i]).append(" ");

        return sb.toString();


    }

    private static float kerekítve (float value, int fasztarisznya) {
        int scale = (int) Math.pow(10, fasztarisznya);
        return  Math.round(value * scale) / scale;
    }

    private static float ppm(float szatKg, float oldatKg){

        return (szatKg/oldatKg)*1000000;

    }

    private static float szatKg(int ECµS){
        final float KE=0.67f;
        return KE*ECµS;
    }
}

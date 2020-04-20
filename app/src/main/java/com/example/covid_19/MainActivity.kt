package com.example.covid_19

import android.content.Context
import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button=findViewById<View>(R.id.inicioBTN) as ImageButton
        var Nombre=findViewById<View>(R.id.nombreTXT) as TextView
        var Edad=findViewById<View>(R.id.edadTXT) as TextView
        var virus=findViewById<View>(R.id.virusBTN) as Button
        var resp=findViewById<View>(R.id.respuestaTXT) as TextView
        var sinto=findViewById<View>(R.id.sintomasBTN) as Button
        var indica=findViewById<View>(R.id.indicacionesBTN) as Button
        var bundle = intent.extras

        if(bundle!=null){
            var coment=bundle.getString("comentario")
            Toast.makeText(this@MainActivity, " "+coment, Toast.LENGTH_SHORT).show()


        }


        button.setOnClickListener(){


            if(Nombre.visibility==View.VISIBLE && Edad.visibility==View.VISIBLE){
                //Si es visible, se oculta
                Nombre.visibility=View.GONE
                Edad.visibility=View.GONE
                resp.visibility=View.VISIBLE

                val EdadInt: Int = Edad.text.toString().toInt()
                if(EdadInt<=25){
                    resp.text=Nombre.text.toString()+", " + "debido a su edad usted se encuentra en un riesgo nivel 3, sin embargo se le recomienda tomar precauciones"
                }else{
                    if(EdadInt>25 && EdadInt<50){
                        resp.text=Nombre.text.toString()+", " + "debido a su edad usted se encuentra en un riesgo nivel 2, se le recomienda tomar los medicamentos y estar en reposo"
                    }else{
                        if(EdadInt>=50 && EdadInt<80){
                            resp.text=Nombre.text.toString()+", " + "debido a su edad usted se encuentra en un riesgo nivel 1, se le recomienda ir al hospital de inmediato"
                        }else{
                            if(EdadInt>80){
                                resp.text=Nombre.text.toString()+", " + "debido a su edad usted se encuentra en un riesgo nivel 1+, se le recomienda ir al hospital de inmediato y solicitar ayuda inmediata"
                            }
                        }
                    }

                }










            }else{
                Nombre.visibility = View.VISIBLE
                Edad.visibility = View.VISIBLE
                resp.visibility= View.GONE
            }



        }
        virus.setOnClickListener(){
            val intent = Intent(this@MainActivity,Virus::class.java)
            val tl: String="Virus"
            val info: String="Los expertos aún están aprendiendo cosas sobre el coronavirus (COVID-19). Debido a que todos los días hay nueva información, las personas pueden sentirse abrumadas. Aquí encontrará respuestas a algunas de las preguntas que puede tener.\n" +
                    "¿Cómo se contagia el coronavirus (COVID-19)?\n" +
                    "\n" +
                    "La gente puede contraer el coronavirus a partir de otras personas infectadas por este virus. Esto ocurre cuando una persona infectada estornuda o tose, dispersando pequeñas gotas de agua por el aire. Esas gotitas pueden aterrizar en la nariz, la boca o los ojos de una persona que se encuentra cerca, o ella las puede inspirar.\n" +
                    "\n" +
                    "Es posible que una persona también contraiga la infección al tocar una superficie cubierta de gotas infectadas y luego se toque la nariz, la boca o los ojos.\n" +
                    "\n" +
                    "Los expertos están estudiando si el virus puede propagarse a través de las heces (cacas).\n" +
                    "¿Una persona infectada por el coronavirus (COVID-19) lo puede contagiar aunque no presente ningún síntoma?\n" +
                    "\n" +
                    "El virus se contagia con mayor facilidad cuando una persona infectada presenta síntomas. Pero el virus también puede propagarse antes de que comiencen los síntomas. Una persona puede tardar de 2 a 14 días en presentar síntoma después contraer el virus."
            val b: Bundle= Bundle()
            b.putString("Info", info)
            b.putString("Titulo", tl)
            intent.putExtras(b)
            startActivity(intent)


        }
        sinto.setOnClickListener(){
            val intent = Intent(this@MainActivity,Virus::class.java)
            val tl: String="Sintomas"
            val info: String="Esté atento a los síntomas\n" +
                    "\n" +
                    "Los síntomas notificados por personas con COVID-19 varían desde aquellos que presentan síntomas leves hasta quienes se enferman gravemente.\n" +
                    "\n" +
                    "Estos síntomas pueden aparecer 2 a 14 días después de la exposición al virus:\n" +
                    "\n" +
                    "    Fiebre\n" +
                    "    Tos\n" +
                    "    Dificultad para respirar (sentir que le falta el aire)\n" +
                    "    Escalofríos\n" +
                    "    Temblores y escalofríos que no ceden\n" +
                    "\n" +
                    "    Dolor muscular\n" +
                    "    Dolor de cabeza\n" +
                    "    Dolor de garganta\n" +
                    "    Pérdida reciente del olfato o el gusto\n" +
                    "\n"+"¿Cuándo buscar atención médica?\n" +
                    "\n" +
                    "Si presenta signos de advertencia de emergencia del COVID-19, busque atención médica de inmediato. Los signos de advertencia de emergencia incluyen*:\n" +
                    "\n" +
                    "    Dificultad para respirar\n" +
                    "    Dolor o presión persistente en el pecho\n" +
                    "    Confusión o dificultad para estar alerta que no haya tenido antes\n" +
                    "    Coloración azulada en los labios o el rostro \n"
            val b: Bundle= Bundle()
            b.putString("Info", info)
            b.putString("Titulo", tl)
            intent.putExtras(b)
            startActivity(intent)
        }
        indica.setOnClickListener(){
            val intent = Intent(this@MainActivity,Virus::class.java)
            val tl: String="Indicaciones"
            val info: String="Aunque por ahora no existe un tratamiento antiviral específico para COVID-19, los sanitarios suelen emplear varios fármacos de forma experimental y/o con uso compasivo. Entre ellos se suele recurrir con frecuencia a un antirretroviral utilizado antes frente al VIH, el lopinavir/ritonavir (Kaletra®). Sin embargo, de momento no ha demostrado efectividad y tiene un elevado riesgo de interacciones con otros medicamentos, además de poder producir molestias abdominales y diarrea.\n" +
                    "\n" +
                    "Otros antivirales en estudio para tratar la infección por SARS-CoV-2 son el remdesivir y el favipiravir. En cualquier caso, los antivirales generalmente sólo tienen una ventana estrecha de actividad, dado que la mayoría de casos sintomáticos de COVID-19 se autolimitan en 7-10 días. Ocurriría como con el oseltamivir en la gripe, que únicamente acorta los días de enfermedad, siempre y cuando se dé temprano. La parte positiva es que los antivirales podrían reducir el riesgo de progresión a formas graves de COVID-19"
            val b: Bundle= Bundle()
            b.putString("Info", info)
            b.putString("Titulo", tl)
            intent.putExtras(b)
            startActivity(intent)
        }


    }




}

package com.example.covid_19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class Virus : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_virus)

        var tituloF=findViewById<View>(R.id.tituloTXT) as TextView
        var inF=findViewById<View>(R.id.contenidoTXT) as TextView
        var button=findViewById<View>(R.id.comentarioBTN) as Button
        var coment=findViewById<View>(R.id.comentarioTXT) as TextView


        var bundle = intent.extras

        if(bundle!=null){
            tituloF.text=bundle.getString("Titulo")
            inF.text=bundle.getString("Info")
        }

        button.setOnClickListener(){
            val intent = Intent(this@Virus, MainActivity::class.java)

            val comentario: String=coment.text.toString()

            val b : Bundle = Bundle()
            b.putString("comentario", comentario)
            intent.putExtras(b)
            startActivity(intent)

        }

    }
}

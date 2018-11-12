package com.example.spart.eva2_4_bundles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener,CheckBox.OnCheckedChangeListener,RadioGroup.OnCheckedChangeListener {
    EditText editTxtNombre,editTxtApellido,editTxtEdad,editTxtSalario;
    CheckBox chbEmpleado;
    RadioGroup rdGrpGenero;
    Button btnEnviar;
    Intent inSecundaria;
    String sGenero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inSecundaria = new Intent(this,Secundaria.class);
        editTxtNombre = findViewById(R.id.editTxtNombre);
        editTxtApellido = findViewById(R.id.editTxtApellido);
        editTxtEdad = findViewById(R.id.editTxtEdad);
        editTxtSalario = findViewById(R.id.editTxtSalario);
        editTxtSalario.setEnabled(false);
        chbEmpleado = findViewById(R.id.chbEmpleado);
        chbEmpleado.setOnCheckedChangeListener(this);
        rdGrpGenero = findViewById(R.id.rdGrpGenero);
        rdGrpGenero.setOnCheckedChangeListener(this);
        btnEnviar = findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Bundle miBundle = new Bundle();
        miBundle.putString("Nombre",editTxtNombre.getText().toString());
        miBundle.putString("Apellido",editTxtApellido.getText().toString());
        miBundle.putInt("Edad", Integer.parseInt(editTxtEdad.getText().toString()));
        if(editTxtSalario.isEnabled()){
            miBundle.putBoolean("Empleado",true);
            miBundle.putDouble("Salario", Double.parseDouble(editTxtSalario.getText().toString()));
        }else{
            miBundle.putBoolean("Empleado",false);
            miBundle.putDouble("Salario", 0);
        }
        miBundle.putString("Genero",sGenero);
        inSecundaria.putExtras(miBundle);
        startActivity(inSecundaria);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(chbEmpleado.isChecked()){
            editTxtSalario.setEnabled(true);
        }else{
            editTxtSalario.setEnabled(false);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId==R.id.rdHombre){
            sGenero = "Hombre";
        }else{
            if(checkedId==R.id.rdMujer){
                sGenero = "Mujer";
            }else{
                sGenero = "otro";
            }
        }
    }
}

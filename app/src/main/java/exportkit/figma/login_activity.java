
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		home
	 *	@date 		Wednesday 12th of October 2022 02:34:27 AM
	 *	@title 		Page 1
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
	

package exportkit.figma;

import android.content.Intent;
import android.os.Bundle;


import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.storeg.DBHelper;

	public class login_activity extends AppCompatActivity {

	
	private View _bg__login_ek2;
	private View rectangle_3_ek2;
	private ImageView fondo_login_ek1;
	private TextView registrate_ek2;
	private View rectangle_5_ek2;
	private View rectangle_11_ek1;
	private ImageView logo_1_ek3;

	EditText usuario, contraseña;
	Button acceder;
	DBHelper DB;


	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		
		_bg__login_ek2 = (View) findViewById(R.id._bg__login_ek2);
		rectangle_3_ek2 = (View) findViewById(R.id.rectangle_3_ek2);
		fondo_login_ek1 = (ImageView) findViewById(R.id.fondo_login_ek1);
		registrate_ek2 = (TextView) findViewById(R.id.registrate_ek2);
		rectangle_5_ek2 = (View) findViewById(R.id.rectangle_5_ek2);
		rectangle_11_ek1 = (View) findViewById(R.id.rectangle_11_ek1);
		logo_1_ek3 = (ImageView) findViewById(R.id.logo_1_ek3);
	
		
		//custom code goes here

		usuario = findViewById(R.id.usuario1);
		contraseña = findViewById(R.id.contraseña1);
		acceder = findViewById(R.id.acceder);
		DB = new DBHelper(this);

		acceder.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				String user = usuario.getText().toString();
				String pass = contraseña.getText().toString();

				if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
					Toast.makeText(login_activity.this, "Todos los campos son requeridos", Toast.LENGTH_SHORT).show();
				else{
					Boolean checkuserpass = DB.checkusernamepassword(user,pass);
					if(checkuserpass==true){
						Toast.makeText(login_activity.this, "Inicio de sesión Exitoso", Toast.LENGTH_SHORT).show();
						Intent intent = new Intent(getApplicationContext(),home_activity.class);
						startActivity(intent);
					}else{
						Toast.makeText(login_activity.this, "Inicio de sesión Fallido", Toast.LENGTH_SHORT).show();

					}

				}

			}
		});
	
	}
}
	
	
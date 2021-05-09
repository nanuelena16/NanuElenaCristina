package com.example.elena.proiectcloud;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ListaReferinteJSONActivity extends AppCompatActivity {

    String continutJson;
    ListView lv;
    ArrayAdapter<Referinta> adaptor;
    ArrayList<Referinta> listaReferinte;
    ArrayList<Autor> autori;
    ArrayList<Referinta> rez;
    int q=100;
    String nume;
    int contorAdaugareRef=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        rez=new ArrayList<>();
        listaReferinte=new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_referinte_json);

        Intent intent=getIntent();
        if(intent!=null) {
            nume=intent.getStringExtra("aa");
        }

        //request la pagina pt json
        Task1 t=new Task1();
        t.execute();

        //ArrayAdapter<Referinta> adapter=new ArrayAdapter<Referinta>(this,  android.R.layout.simple_list_item_1,listaReferinte);

        lv=(ListView)findViewById(R.id.lv_referinteJson);
        adaptor=new AdaptorReferinte(this, R.layout.afisare_referinta, listaReferinte);
        lv.setAdapter(adaptor);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Referinta referinta=(Referinta)adaptor.getItem(position);

                Dao d=new Dao(getApplicationContext());

                int id_user=d.returnId(nume);

                ArrayList<Autor> autoriRef=new ArrayList<>();
                for(int i=0;i<referinta.lungime();i++) {
                    autoriRef.add(referinta.getAutori(i));
                }

                Referinta referinta2=new Referinta(referinta.getTitluJurnal(),referinta.getAnAparitie(),referinta.getTipDocument(),
                                                      referinta.getTitluPublicatie(),autoriRef,id_user);

                //d.adaugaReferintaPtClasa(referinta2);

                //contorAdaugareRef++;

                if(d.adaugaReferintaPtClasa(referinta2)!=0) {
                    Context context = getApplicationContext();
                    CharSequence text = "S-a adaugat referinta!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });


    }

    class Task1 extends AsyncTask<Void,Void,ArrayList> {

        String jsonUrl;

        @Override
        protected void onPreExecute() {
            jsonUrl="http://pdm.ase.ro/papers.json";
        }

        @Override
        protected ArrayList<Referinta> doInBackground(Void... voids) {
            try {
                URL url = new URL(jsonUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                InputStream is = httpURLConnection.getInputStream();

                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                StringBuilder sb = new StringBuilder();

                while ((continutJson = br.readLine()) != null) {
                    sb.append(continutJson);
                    sb.append("\n");
                }

                br.close();
                is.close();
                httpURLConnection.disconnect();

                //return sb.toString().trim();

                JSONArray jsonArray = new JSONArray(sb.toString());
                Log.d("stringjson", sb.toString());
                //listaReferinte=null;

                for (int i = 0; i < jsonArray.length(); i++) {
                    autori=new ArrayList<>();

                    JSONObject obiect1 = jsonArray.getJSONObject(i);
                    String titluJurnal = (String) obiect1.get("journalTitle");
                    int anAparitie = Integer.parseInt((String) obiect1.get("publicationDate"));
                    String tipDocument = (String) obiect1.get("documentType");

                    JSONObject obiect2 = obiect1.getJSONObject("title");
                    String titlu = (String) obiect2.get("text");


                    if(i==0 || i==2 || i==5) {
                        JSONArray obiect4 = obiect1.getJSONArray("authors");
                        for (int j = 0; j < obiect4.length(); j++) {
                            JSONObject autor = obiect4.getJSONObject(j);
                            String numeAutor = (String) autor.get("name");
                            String emailAutor = (String) autor.get("email");
                            Autor a = new Autor(j, numeAutor, emailAutor);
                            autori.add(a);
                        }
                    } else if(i==1 || i==3 || i==4) {
                        JSONObject obiect3=obiect1.getJSONObject("authors");
                        JSONObject obiect4=obiect3.getJSONObject("author");
                        String numeAutor=(String) obiect4.get("name");
                        String emailAutor=(String) obiect4.get("email");
                        Autor a=new Autor(q,numeAutor,emailAutor);
                        autori.add(a);
                        q++;
                    }


                    Referinta referinta = new Referinta(i,titluJurnal, anAparitie, tipDocument, titlu,autori);
                    listaReferinte.add(referinta);

                    Log.d("aaa", "aaaaa");

                    Log.d("listaRef", referinta.toString());
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
                Log.d("aaaa", e.toString());
            }

            return listaReferinte;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(ArrayList rezultat) {
           /* lv=(ListView)findViewById(R.id.lv_referinteJson);
            //FA ADAPTOR PT ASTA
            adaptor=new AdaptorReferinte(this, R.layout.afisare_referinta, listaReferinte);
            lv.setAdapter(adaptor); */

           for(int i=0;i<rezultat.size();i++)
               rez.add((Referinta)rezultat.get(i));

        }
    }



}

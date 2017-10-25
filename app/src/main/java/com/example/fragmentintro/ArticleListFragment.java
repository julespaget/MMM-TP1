package com.example.fragmentintro;

import java.util.ArrayList;
import java.util.HashMap;


import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ArticleListFragment extends Fragment {
    
    private ListView articleList;
    private OnTitleSelectedListener onTitleSelectedListener ;


    public interface OnTitleSelectedListener {
        void OnTitleSelected(int index) ;
    }

	
	@Override    
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.article_list_layout, container, false);

        //Récupération de la listview créée dans le fichier main.xml
        articleList = (ListView) view.findViewById(R.id.listview_article_list);
 
        //Création de la ArrayList qui nous permettra de remplire la listView
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
 
        //On déclare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> map;
 
        //Création d'une HashMap pour insérer les informations du premier item de notre listView
        map = new HashMap<String, String>();
        //on insère un élément titre que l'on récupérera dans le textView titre créé dans le fichier affichageitem.xml
        map.put("titre", "Word");
        //on insère un élément description que l'on récupérera dans le textView description créé dans le fichier affichageitem.xml
        map.put("description", "Editeur de texte");
        //on insère la référence à l'image (convertit en String car normalement c'est un int) que l'on récupérera dans l'imageView créé dans le fichier affichageitem.xml
        map.put("img", String.valueOf(R.drawable.ic_launcher));
        //enfin on ajoute cette hashMap dans la arrayList
        listItem.add(map);
 
        //On refait la manip plusieurs fois avec des données différentes pour former les items de notre ListView
 
        map = new HashMap<String, String>();
        map.put("titre", "Info 1");
        map.put("description", "Bla bla bla");
        map.put("img", String.valueOf(R.drawable.ic_launcher));
        listItem.add(map);
 
        map = new HashMap<String, String>();
        map.put("titre", "Info 2");
        map.put("description", "Bla bla bla");
        map.put("img", String.valueOf(R.drawable.ic_launcher));
        listItem.add(map);
 
        map = new HashMap<String, String>();
        map.put("titre", "Info 3");
        map.put("description", "Bla bla bla");
        map.put("img", String.valueOf(R.drawable.ic_launcher));
        listItem.add(map);
 
        //Création d'un SimpleAdapter qui se chargera de mettre les items présent dans notre list (listItem) dans la vue affichageitem
        SimpleAdapter mSchedule = new SimpleAdapter (getActivity(), listItem, R.layout.article_list_item,
               new String[] {"img", "titre", "description"}, new int[] {R.id.img, R.id.titre, R.id.description});
 
        //On attribue à notre listView l'adapter que l'on vient de créer
        articleList.setAdapter(mSchedule);
        
        
        
        articleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	
        	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				//on récupère la HashMap contenant les infos de notre item (titre, description, img)
        		HashMap<String, String> map = (HashMap<String, String>) articleList.getItemAtPosition(position);
                onTitleSelectedListener.OnTitleSelected(position) ;

        		/*//on créer une boite de dialogue
        		AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
        		//on attribut un titre à notre boite de dialogue
        		adb.setTitle("Sélection Item");
        		//on insère un message à notre boite de dialogue, et ici on affiche le titre de l'item cliqué
        		adb.setMessage("Votre choix : "+map.get("titre"));
        		//on indique que l'on veut le bouton ok à notre boite de dialogue
        		adb.setPositiveButton("Ok", null);
        		//on affiche la boite de dialogue
        		adb.show();*/

			}

         });

        return view;
    }
}
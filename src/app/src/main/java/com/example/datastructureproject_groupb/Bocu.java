package com.example.datastructureproject_groupb;

import android.app.Application;

import com.example.datastructureproject_groupb.ImplementacionesEstructurasDeDatos.DynamicUnsortedList;
import com.example.datastructureproject_groupb.ImplementacionesEstructurasDeDatos.HashSetFavoritos;
import com.example.datastructureproject_groupb.ImplementacionesEstructurasDeDatos.HashTableUsuarios;
import com.example.datastructureproject_groupb.db.DbEventos;
import com.example.datastructureproject_groupb.db.DbExpositor;
import com.example.datastructureproject_groupb.db.DbSesion;
import com.example.datastructureproject_groupb.db.DbUsuariosComunes;
import com.example.datastructureproject_groupb.entidades.artista.Artista;
import com.example.datastructureproject_groupb.entidades.evento.Evento;
import com.example.datastructureproject_groupb.entidades.info_sesion.UsuarioComun;
import com.example.datastructureproject_groupb.entidades.info_sesion.UsuarioRegistrado;
import com.example.datastructureproject_groupb.entidades.pagina_descubrir.OrdenEventos;

import java.util.HashSet;

public class Bocu extends Application {

    public final static int SIN_REGISTRAR = 0;
    public final static int USUARIO_COMUN = 1;
    public final static int ARTISTA = 2;
    public static HashSetFavoritos idFavoritos;
    public static HashTableUsuarios idUsuarios;
    public static DynamicUnsortedList<Evento> eventos, eventosExpositor, eventosFavoritos;
    public static DynamicUnsortedList<Integer> posicionesEventosExpositor;
    public static DynamicUnsortedList<Artista> expositores;
    public static DynamicUnsortedList<UsuarioComun> usuariosComunes;
    public static UsuarioRegistrado usuario;
    public static int estadoUsuario = SIN_REGISTRAR;
    public static String[] filtrosEventos = new String[]{};
    public static OrdenEventos ordenEventos;
    public static final String [] LOCALIDADES = new String[]{"Usaquén", "Chapinero", "Santa Fe", "San Cristóbal", "Usme", "Tunjuelito", "Bosa", "Kennedy", "Fontibón", "Engativá", "Suba", "Barrios Unidos", "Teusaquillo", "Los Mártires", "Antonio Nariño", "Puente Aranda", "La Candelaria", "Rafael Uribe Uribe", "Ciudad Bolívar", "Sumapaz"};
    public static final String [] INTERESES = new String[]{"Musica", "Talleres"};
    public static final String [] PLATAFORMAS = new String[]{"Discord", "Meet", "Skype", "Teams", "Zoom"};

    @Override
    public void onCreate() {
        super.onCreate();


        DbEventos dbEventos = new DbEventos(this);
        DbExpositor dbExpositor = new DbExpositor(this);
        DbUsuariosComunes dbUsuariosComunes=new DbUsuariosComunes(this);

        eventos = dbEventos.obtenerEventos();

        usuario = null;

        usuariosComunes = dbUsuariosComunes.obtenerUsuariosComunes();

        expositores = dbExpositor.obtenerExpositores();

        idUsuarios = dbUsuariosComunes.obtenerUsuariosComunesHash();

        DbSesion dbSesion=new DbSesion(getApplicationContext());
        dbSesion.sesionActiva();

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}

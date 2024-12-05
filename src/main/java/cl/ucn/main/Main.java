package cl.ucn.main;

import cl.ucn.modelo.Usuario;
import cl.ucn.util.BusquedaUsuarioBD;
import cl.ucn.util.BusquedaUsuarioProxy;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        BusquedaUsuarioBD busquedaUsuarioBD = new BusquedaUsuarioBD();
        BusquedaUsuarioProxy bp = new BusquedaUsuarioProxy(busquedaUsuarioBD);

        for (int rut: Arrays.asList(89830291, 9233271, 11234202, 15786780, 22739296))
            bp.buscarUsuario(rut);
    }
}
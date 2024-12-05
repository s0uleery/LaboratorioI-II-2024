package cl.ucn.util;


import cl.ucn.interfaz.ProxyInterface;
import cl.ucn.modelo.Usuario;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BusquedaUsuarioProxy implements ProxyInterface {


    private ProxyInterface base;

    public BusquedaUsuarioProxy(ProxyInterface base) {

        this.base = base;
    }

    public List<Usuario> loadCsv(){

        String[] values = null;
        List<Usuario> usuarios = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader("externo.csv"));) {
            while ((values = csvReader.readNext()) != null) {

                Usuario usuario = new Usuario();
                usuario.setRut(Integer.valueOf(values[0]));
                usuario.setNombre(values[1]);
                usuario.setTienePermiso(Boolean.valueOf(values[2]));
                usuario.setRecursosMultimedia(null);
                usuarios.add(usuario);
            }
        } catch (FileNotFoundException | CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return usuarios;

    }

    @Override
    public Usuario buscarUsuario(int rut) {

        Usuario usuario = base.buscarUsuario(rut);
        boolean flag = false;
        // no está en base de datos, buscamos en archivo
        if (usuario == null){
            List<Usuario> lstUsuario = this.loadCsv();
            for (Usuario usuario1 : lstUsuario) {
                if (usuario1.getRut() == rut) {
                    usuario = usuario1;
                    flag = true;
                    break;
                }
            }
        }
        else
            flag = true;

        if (flag && usuario.getRecursosMultimedia() != null){
            if (usuario.isTienePermiso())
                System.out.println("El usuario " + usuario.getRut() + " tiene permisos sobre archivo: " + usuario.getRecursosMultimedia().getNombre());
            else {
                if (!usuario.isTienePermiso() && usuario.getRecursosMultimedia().isProtegido())
                    System.out.println("El usuario " + usuario.getRut() + " no tiene permisos sobre archivo: " + usuario.getRecursosMultimedia().getNombre());
                else if (!usuario.isTienePermiso() && !usuario.getRecursosMultimedia().isProtegido()) {
                    System.out.println("El usuario " + usuario.getRut() + "tiene permisos sobre archivo: " + usuario.getRecursosMultimedia().getNombre());
                }
            }
        }
        else
            System.out.println("El usuario " + usuario.getRut() + " no tiene permisos archivos asociados");

        return usuario;
    }
}

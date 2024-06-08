<div align = “justify">

Proyecto BAE | Miguel Ovalle López | Bases de Datos 1ºDAM

## ¿En qué consiste este proyecto?
>Proyecto de final de curso para la asignatura de Base de Datos que consiste en desarrollar una aplicación personalizada de gestión, capaz de crear, leer, actualizar y eliminar (CRUD) información relevante utilizando Mongodb Atlas como base de datos no relacional y utilizando Maven como herramienta de gestión de dependencias y para la construcción del proyecto.

## Modelo de datos

- Anime:
  - Título (String): El título del anime.
  - Género (String): El género del anime.
  - Autor (String):  El autor del anime.

- Personaje:
  - Nombre (String): El nombre del personaje.
  - Anime (String): El anime al que pertenece el personaje.

- Estudio:
  - Nombre (String): El nombre del estudio.
  - Ubicación (String): La ubicación del estudio.

## Descripción de las Principales Funcionalidades Implementadas
>El programa implementa las operaciones CRUD (Crear, Leer, Actualizar y Eliminar) para cada una de las colecciones.

- Funcionalidades para Anime:
  - Crear Anime: Permite agregar un nuevo anime a la base de datos.
  - Leer Animes: Recupera y muestra todos los animes almacenados.
  - Actualizar Anime: Actualiza la información de un anime existente.
  - Eliminar Anime: Elimina un anime de la base de datos.
    
- Funcionalidades para Personaje:
  - Crear Personaje: Permite agregar un nuevo personaje a la base de datos.
  - Leer Personaje: Recupera y muestra todos los personajes almacenados.
  - Actualizar Personaje: Actualiza la información de un personaje existente.
  - Eliminar Personaje: Elimina un personaje de la base de datos.
    
- Funcionalidades para Estudio:
  - Crear Estudio: Permite agregar un nuevo estudio a la base de datos.
  - Leer Estudio: Recupera y muestra todos los estudios almacenados.
  - Actualizar Estudio: Actualiza la información de un estudio existente.
  - Eliminar Estudio: Elimina un estudio de la base de datos.

 ## Ejemplos de Uso de la Aplicación

### Crear un nuevo anime

```
    public static void crearAnime(ControladorAnime controladorAnime){
        controladorAnime.crearAnime("Naruto", "Shonen", "Masashi Kishimoto");
        System.out.println("Anime creado.");
    }
```

### Leer todas las series

```
    public static void leerAnimes(ControladorAnime controladorAnime){
        List<Anime> animes = controladorAnime.obtenerTodos();
        for(Anime anime : animes){
            System.out.println("Anime: "+ anime.getTitulo()+ ", Género: "+anime.getGenero()+", Autor :"+anime.getAutor()+".");
        }
    }
```

### Actualizar un anime

```
    public static void actualizarAnime(ControladorAnime controladorAnime){
        List<Anime> animes = controladorAnime.obtenerTodos();
        if (!animes.isEmpty()) {
            Anime anime = animes.get(0);
            controladorAnime.actualizarAnime(anime.getId(), "Naruto Shippuden", "Shonen", "Masashi Kishimoto");
            System.out.println("Anime actualizado a"+anime.getTitulo());
        }
    }
```

### Eliminar un anime

```
   public static void eliminarAnime(ControladorAnime controladorAnime){
        List<Anime> animes = controladorAnime.obtenerTodos();
        if (!animes.isEmpty()) {
            Anime anime = animes.get(0);
            controladorAnime.eliminarAnime(anime.getId());
            System.out.println("Anime"+anime.getTitulo()+"eliminado.");
        }
    }
```

### Crear un nuevo personaje

```
    public static void crearPersonaje(ControladorPersonajes controladorPersonajes){
        controladorPersonajes.crearPersonaje("Naruto Uzumaki", "Naruto");
    }
```

### Leer todos los personaje

```
    public static void leerPersonajes(ControladorPersonajes controladorPersonajes){
        List<Personajes> personajes = controladorPersonajes.obtenerTodos();
        for(Personajes personaje : personajes){
            System.out.println("Nombre: "+ personaje.getNombre()+ ", Anime: "+personaje.getAnime()+".");
        }  
    }
```

### Actualizar un personaje

```
    public static void actualizarPersonaje(ControladorPersonajes controladorPersonajes){
        List<Personajes> personajes = controladorPersonajes.obtenerTodos();
        if (!personajes.isEmpty()) {
            Personajes personaje = personajes.get(0);
            controladorPersonajes.actualizarPersonaje(personaje.getId(), "Naruto Uzumaki", "Naruto");
            System.out.println("Anime actualizado a"+personaje.getNombre());
        }
    }
```

### Eliminar un personaje

```
 public static void eliminarPersonaje(ControladorPersonajes controladorPersonajes){
        List<Personajes> personajes = controladorPersonajes.obtenerTodos();
        if (!personajes.isEmpty()) {
            Personajes personaje = personajes.get(0);
            controladorPersonajes.eliminarPersonaje(personaje.getId());
            System.out.println("Nombre"+personaje.getNombre()+"eliminado.");
        }
    }

```

### Crear un nuevo estudio

```
    public static void crearEstudio(ControladorEstudio controladorEstudio){
        controladorEstudio.crearEstudio("Mappa", "Tokyo");
    }
```

### Leer todos los estudios

```
    public static void leerEstudios(ControladorEstudio controladorEstudio){
        List<Estudio> estudios = controladorEstudio.obtenerTodo();
        for(Estudio estudio : estudios){
            System.out.println("Nombre: "+ estudio.getNombre()+ ", Ubicación: "+estudio.getUbicacion()+".");
        } 
    }
```

### Actualizar un estudio

```
    public static void actualizarEstudio(ControladorEstudio controladorEstudio){
        List<Estudio> estudios = controladorEstudio.obtenerTodo();
        if (!estudios.isEmpty()) {
            Estudio estudio = estudios.get(0);
            controladorEstudio.actualizarEstudio(estudio.getId(), "mappa", "Tokyo");
            System.out.println("Estudio actualizado a"+estudio.getNombre());
        }
    }
```

### Eliminar un estudio

```
    public static void eliminarEstudio(ControladorEstudio controladorEstudio){
        List<Estudio> estudios = controladorEstudio.obtenerTodo();
        if (!estudios.isEmpty()) {
            Estudio estudio = estudios.get(0);
            controladorEstudio.eliminarEstudio(estudio.getId());
            System.out.println("Nombre"+estudio.getNombre()+"eliminado.");
            
        }
    }
```


  
</div>

import axios from "axios";

const API_URL = "http://localhost:8080/api/books/";

const registrarLibro = async (libro) => {
    try {
        const response = await axios.post(API_URL, libro);
        return response.data;
    } catch (error) {
        console.error(error);
    }
}

const obtenerLibros = async () => {
    try {
        const response = await axios.get(API_URL);
        const libros = response.data;
        return libros;
    } catch (error) {
        console.error(error);
    }
}

const eliminarLibro = async (id) => {
    try {
        console.log('ID del libro a eliminar:', id);
        const response = await axios.delete(API_URL + id);
        console.log('Respuesta del servidor:', response);
        return response.data;
    } catch (error) {
        console.error('Error al eliminar el libro:', error);
    }
};


const getBooksByAutor = async () => {
    try {
        const response = await axios.get(API_URL + "orderAutor");
        console.log(response);
        return response.data;
    } catch (error) {
        console.error(error);
    }
};

const getBooksByFecha = async () => {
    try {
        const response = await axios.get(API_URL + "orderFecha");
        console.log(response);
        return response.data;
    } catch (error) {
        console.error(error);
    }
};


export default {
    registrarLibro,
    obtenerLibros,
    eliminarLibro,
    getBooksByAutor,
    getBooksByFecha
};
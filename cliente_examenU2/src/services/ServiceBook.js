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

export default {
    registrarLibro,
    obtenerLibros
};
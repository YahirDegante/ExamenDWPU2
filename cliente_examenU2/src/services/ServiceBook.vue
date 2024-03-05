import axios from "axios";

const API_URL = "http://localhost:5173/api/books/";

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
    obtenerLibros
};
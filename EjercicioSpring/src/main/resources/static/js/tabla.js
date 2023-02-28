$(document).ready(function() {
    cargarProductos();
    //$('#productos').DataTable();
} );

// Listar productos

async function cargarProductos() {

    // Obtener los productos

 try {
    const request = await fetch('/listar', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        });
    let productos = await request.json();
    console.log(productos);
    let listadoHTML = '';
    for(let producto of productos) {
        listadoHTML += '<tr><td><input type="checkbox"></td><td>' + producto.id + '</td><td>' + producto.nombre + '</td><td>' + producto.descripción + '</td><td>' + producto.precio + '</td></tr>';

    }
    document.querySelector("#productos #tbodyProductos").innerHTML = listadoHTML;
    } catch (error) {
        console.log(error);
    }

    // Agregar evento click a los checkboxes

    let checkboxes = document.querySelectorAll("#productos input[type='checkbox']");
    for (let checkbox of checkboxes) {
      checkbox.addEventListener('click', function() {
        // Desactivar todos los demás checkboxes
        for (let otherCheckbox of checkboxes) {
          if (otherCheckbox != checkbox) {
            otherCheckbox.checked = false;
          }
        }


      });
    }
}

// Insertar productos

async function insertarProducto() {

    // Obtener los datos del formulario

    let nombre = document.getElementById("nombre").value;
    let descripción = document.getElementById("descripción").value;
    let precio = document.getElementById("precio").value;

    // Insertar el producto

    try {
        const request = await fetch(`/insertar/${nombre}/${descripción}/${precio}`, {
            method: 'POST'
        });
        cargarProductos();
    }
    catch (error) {
        console.log(error);
    }
}

// Eliminar producto

async function eliminarProducto() {

    // Obtener el id del producto seleccionado

    let checkboxes = document.querySelectorAll("#productos input[type='checkbox']");
    let id = 0;
    for (let checkbox of checkboxes) {

          if (checkbox.checked) {
                id = checkbox.parentElement.nextElementSibling.innerHTML;
            }
    }
    console.log(id);

    // Eliminar el producto

    try {
        const request = await fetch(`/eliminar/${id}`, {
            method: 'DELETE'
        });
        cargarProductos();

    } catch (error) {
        console.log(error);
    }

}

// Actualizar producto

async function actualizarProducto() {

        // Obtener el id del producto seleccionado

        let checkboxes = document.querySelectorAll("#productos input[type='checkbox']");
        let id = 0;
        for (let checkbox of checkboxes) {

            if (checkbox.checked) {
                    id = checkbox.parentElement.nextElementSibling.innerHTML;
                }
        }
        console.log(id);

        // Obtener los datos del formulario

        let nombre = document.getElementById("nombre").value;
        let descripción = document.getElementById("descripción").value;
        let precio = document.getElementById("precio").value;

        // Actualizar el producto

        try {
            const request = await fetch(`/actualizar/${id}/${nombre}/${descripción}/${precio}`, {
                method: 'PUT'
            });
            cargarProductos();
        }
        catch (error) {
            console.log(error);
        }
}
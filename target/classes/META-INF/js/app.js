$( document ).ready(function() {
var saveBtn = document.querySelector('#save');
saveBtn.addEventListener('click', function () {

    var name =$('name').val();
    var typeOfMine = $('typeOfMine').val();
    var specification = $('specification').val();
    var description = $('description').val();
    var photo = $('photo').val();

   var mineToSend = {
       name: name,
       typeOfMine: typeOfMine,
       specification: specification,
       description: description,
       photo: photo
   }
   var head = new Headers({
       'content-type': 'application/json'
   })

    var myInit = {
        method: 'POST',
        headers: head,
        mode: 'cors',
        cache: 'default',
        body: JSON.stringify(mineToSend)
    };
    fetch("http://localhost:8080/mine/save", myInit).then(function (response) {
        console.log(response);
    })
})

});
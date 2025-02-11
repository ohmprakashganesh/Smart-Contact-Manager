console.log("admin user");

document.querySelector("#profileImg").addEventListener('change',function(event){
     var file= event.target.files[0];
     let reader= new FileReader();
     reader.onload=function(){
        document.getElementById("image").src=reader.result;
     };
     reader.readAsDataURL(file);
})
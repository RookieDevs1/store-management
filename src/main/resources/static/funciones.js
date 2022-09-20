function delete(id) {
swal({
   title: "Estás Seguro de Eliminar?",
   text: "Once deleted, you will not be able to recover this imaginary file!",
   icon: "warning",
   buttons: true,
   dangerMode: true,
 })
 .then((ok) => {
   if (ok) {
       $.ajax({
        url:"/deleteEmployee/"+id,
        success: function(res) {
            console.log(res);
       },
   });
     swal("Poof! Your imaginary file has been deleted!", {
       icon: "success",
     }).then((ok)=>{
         if(ok){
            location.href="redirect:/employee";
     }
     });
   } else {
     swal("Your imaginary file is safe!");
   }
 });

 }
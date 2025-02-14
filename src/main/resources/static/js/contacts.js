
const $targetEl = document.getElementById('contacts_modal');

// options with default values
const options = {
    placement: 'bottom-right',
    backdrop: 'dynamic',
    backdropClasses:
        'bg-gray-900/50 dark:bg-gray-900/80 fixed inset-0 z-40',
    closable: true,
    onHide: () => {
        console.log('modal is hidden');
    },
    onShow: () => {
        console.log('modal is shown');
    },
    onToggle: () => {
        console.log('modal has been toggled');
    },
};

// instance options object
const instanceOptions = {
  id: 'contacts_modal',
  override: true
};

const contactModal =new Modal($targetEl, options, instanceOptions);

function openModal(){
    contactModal.show();
}

function closeModal(){
    contactModal.hide();
}
async function loadData(id){
    console.log(id);


    console.log(id);
    try{
        const data= await (
            await fetch(`http://localhost:8080/contact/single/${id}`)
        ).json();
        console.log(data);
        console.log(data.name);
        document.getElementById("name").innerHTML=data.name;
        document.getElementById("Picture").src=data.picture;

        document.getElementById("email").innerHTML=data.email;
        document.getElementById("phone").innerHTML=data.phoneNumber;
        document.getElementById("description").innerHTML=data.description;
        document.getElementById("address").innerHTML=data.address;
        document.getElementById("link1").innerHTML="google.com";



        
    }catch(error){
        console.log(error);
    }
    
     openModal();


    //fetch data 
}
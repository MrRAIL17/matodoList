let taskList = document.getElementById('taskList');
let addBtn = document.getElementById('add-btn');
addBtn.addEventListener('click', ()=>addTask())
function addTask(){
    console.log('Hello Zolrd');
    
    let taskinput = document.getElementById('taskInput');
    let taskText =taskinput.ariaValueMax;
    if(taskText===""){
        return;
    }

    let li = document.createElement('li')
    
    li.innerHTML = taskText;

    let editButton = document.createElement('button');

    editButton.innerHTML = '<ion-icon name="pencil-outline"class="modify"></ion-icon>'

    editButton.onclick = function(){
        editTask(li);
    }

let deleteButton = document.createElement('button');
deleteButton.innerHTML = '<ion-icon name="trash-outline"class="delete"></ion-icon>'

deleteButton.onclick = function(){
    deleteTast(li)
}

li.appendChild(editButton);
li.appendChild(deleteButton);

taskList.appendChild(li);

taskinput.value = "";
}

function editTask(task){
    let taskTextElement = task.firstChild;
    let taskText = taskTextElement.textContent;
    let newTaskText = prompt('Modifier la tache:',taskText);
    
    if(newTaskText === null || newTaskText ===""){
        return;
    }
    taskTextElement.textContent = newTaskText; 
}


function deleteTast(task){
    taskList.removeChild(task);  
}
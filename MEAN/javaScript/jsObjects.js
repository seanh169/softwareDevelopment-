// //Challenge 1
// //Print all of the students and their cohort.
// let students = [
//     {name: 'Remy', cohort: 'Jan'},
//     {name: 'Genevieve', cohort: 'March'},
//     {name: 'Chuck', cohort: 'Jan'},
//     {name: 'Osmund', cohort: 'June'},
//     {name: 'Nikki', cohort: 'June'},
//     {name: 'Boris', cohort: 'June'}
// ];

// for(let student in students){
// 	console.log("Name: " + students[student].name + ", Cohort: " + students[student].cohort); 
// }


let users = {
    employees: [
        {'first_name':  'Miguel', 'last_name' : 'Jones'},
        {'first_name' : 'Ernie', 'last_name' : 'Bertson'},
        {'first_name' : 'Nora', 'last_name' : 'Lu'},
        {'first_name' : 'Sally', 'last_name' : 'Barkyoumb'}
    ],
    managers: [
       {'first_name' : 'Lillian', 'last_name' : 'Chambers'},
       {'first_name' : 'Gordon', 'last_name' : 'Poe'}
    ]
 };


for(job in users){
        console.log(job.toUpperCase());
        for(let i=0;i<users[job].length;i++){
            let user = users[job][i];
            let len  = user.first_name.length+user.last_name.length;
            console.log(i+1+" - "+user.last_name.toUpperCase()+", "+user.first_name.toUpperCase()+" - "+len);
        }
    }
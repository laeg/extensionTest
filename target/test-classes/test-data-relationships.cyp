CREATE

(pieter:User {name:'Pieter Cailliau'}),
(luke: User {name:'Luke Gannon'}),
(category1:Category {name:"category1"}),

(pieter)-[:INTERESTED_IN {strength: 5}]->(category1),
(luke)-[:INTERESTED_IN {strength: 1}]->(category1),
(pieter)<-[:CREATED]-(category1);
// This is a test JS file for testing HTTP requests


const url = 'http://localhost:8080/api/'

async function getAllFood() {
    console.log('Getting all food in DB: \n');
    let target = url + 'food/all';

    await fetch(target, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => {
        if (!response.ok) {
            throw new Error('Response code was not 200');
        }
        return response.json();
    })
    .then(results => {
        results.forEach(info => {
            console.log(info);
        });
    })
    .catch(error => {
        console.error('Error gathering Food. Message: ' + error);
    });

};

async function getOneFood(id) {
    console.log('Getting one food by ID in DB: \n');
    let target = url + 'food/' + id;

    await fetch(target, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => {
        if (!response.ok) {
            throw new Error('Response code was not 200');
        }
        return response.json();
    })
    .then(results => {
        console.log(results);
    })
    .catch(error => {
        console.error('Error gathering Food. Message: ' + error);
    });

};

async function createOneFood() {
    console.log('Creating one new food in DB: \n');

    let target = url + 'food/new';
    let jason = {'userId': 1, 'foodId': 7, 'name': 'Fart', 'qty': 1, 'unit': 'Whole'};

    await fetch(target, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(jason)
    }).then(response => {
        if (!response.ok) {
            throw new Error('Response code was not 200');
        }
        return response.json();
    })
    .then(results => {
        console.log(results);
        // results.forEach(info => {
        //     console.log(info);
        // });
    })
    .catch(error => {
        console.error('Error loading. Message: ' + error);
    });
};

async function createManyFoods() {
    console.log('Creating many new foods in DB: \n');

    let target = url + 'food/new/mass';
    let jason = [ {'userId': 1, 'foodId': 8, 'name': 'ze pescal', 'qty': 1, 'unit': 'lbs'},
        {'userId': 1, 'foodId': 9, 'name': 'liberal tears', 'qty': 20, 'unit': 'Whole'},
        {'userId': 1, 'foodId': 10, 'name': 'Fart', 'qty': 1, 'unit': 'Whole'},];

    await fetch(target, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(jason)
    }).then(response => {
        if (!response.ok) {
            throw new Error('Response code was not 200');
        }
        return response.json();
    })
    .then(results => {
        console.log(results);
    })
    .catch(error => {
        console.error('Error loading. Message: ' + error);
    });
};

async function deleteFood() {
    let id = 9;
    let target = url + 'food/' + id;

    console.log('Deleting food id: ' + id);

    await fetch(target, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        console.log(response);
    })
    .catch(error => {
        console.error('Error loading. Message: ' + error);
    });

}

async function testEverything() {
    // console.log('API TESTS: ');
    // console.log('--------------------------------------');
    // await getAllFood();
    // console.log('--------------------------------------');
    // await createOneFood();
    // console.log('--------------------------------------');
    // await createManyFoods();
    // console.log('--------------------------------------');
    // await getAllFood();
    // console.log('--------------------------------------');
    // await getOneFood(10);
    // console.log('--------------------------------------');
    await deleteFood();
    console.log('--------------------------------------');
    // await getOneFood(10);
    // console.log('--------------------------------------');
    await getAllFood();
    console.log('--------------------------------------');
};

testEverything();
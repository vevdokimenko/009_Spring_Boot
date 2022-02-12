const appUrl = document.location.href + 'goods';

const searchByBrand = () => {
    const brand = document.getElementById("search_field").value;
    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            const good = JSON.parse(this.responseText);

            let html = '';
            good.forEach((item) => {
                html += `<h2>${item.brand} ${item.name}</h2>`
            });

            document.getElementById("search").innerHTML = html;
        }
    };
    xhr.open("GET", `${appUrl}/findByBrand?brand=${brand}`, true);
    xhr.send();
}

const deleteGood = (goodId) => {
    const xhr = new XMLHttpRequest();
    window.location.reload();
    xhr.open("GET", `${appUrl}/delete/${goodId}`, true);
    xhr.send();
}

const createGoods = () => {
    const brand = document.getElementById("goods_brand").value;
    const name = document.getElementById("goods_name").value;
    const xhr = new XMLHttpRequest();   // new HttpRequest instance
    xhr.open("POST", `${appUrl}/save`);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify({brand: brand, name: name}));

    window.location.reload();
}

const loadGoods = () => {
    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            const goods = JSON.parse(this.responseText);
            goods.sort((a,b) => {
                return a.id - b.id
            });
            let html = '<tr>\n' +
                '        <th>Goods id</th>\n' +
                '        <th>Goods brand</th>\n' +
                '        <th>Goods name</th>\n' +
                '        <th>Delete</th>\n' +
                '    </tr>';
            for (let i = 0; i < goods.length; i++) {
                const item = goods[i];
                html = html + '<tr><td>' + item.id + '</td>\n' +
                    '        <td>' + item.brand + '</td>\n' +
                    '        <td>' + item.name + '</td>\n' +
                    '        <td><button onclick="deleteGood(' + item.id + ')">Delete</button></td></tr>';

            }
            document.getElementById("goodsList").innerHTML = html;
        }
    };
    xhr.open("GET", `${appUrl}/findAll`, true);
    xhr.send();
}

loadGoods();

document.getElementById("searchByBrand").addEventListener('click', searchByBrand);
document.getElementById("createGoods").addEventListener('click', createGoods);
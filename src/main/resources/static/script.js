
    function showSortOptions() {
        var sortOptions = document.getElementById("sortOptions");
        sortOptions.style.display = "block";
    }

    function hideSortOptions() {
        var sortOptions = document.getElementById("sortOptions");
        sortOptions.style.display = "none";
    }

    var currentSort = ''; // Store the current sorting order

    function searchBooks() {
        var input, filter, cards, cardContainer, title, i;
        input = document.getElementById("searchInput");
        filter = input.value.toUpperCase();
        cardContainer = document.getElementById("cardContainer");
        cards = cardContainer.getElementsByClassName("col");

        for (i = 0; i < cards.length; i++) {
            title = cards[i].querySelector(".card-title");
            var firstChar = title.innerText.charAt(0).toUpperCase();
            if ((currentSort === '' || currentSort === 'name') && firstChar === filter) {
                cards[i].style.display = "";
            } else {
                cards[i].style.display = "none";
            }
        }

        // Show all cards if search input is cleared
        if (filter === '') {
            var allCards = document.getElementsByClassName("col");
            for (i = 0; i < allCards.length; i++) {
                allCards[i].style.display = "";
            }
        }
    }

    function sortByBookName() {
        var cards = Array.from(document.getElementsByClassName("col"));

        cards.sort(function(a, b) {
            var nameA = a.querySelector(".card-title").innerText.toLowerCase();
            var nameB = b.querySelector(".card-title").innerText.toLowerCase();
            return nameA.localeCompare(nameB);
        });

        var cardContainer = document.getElementById("cardContainer");
        cardContainer.innerHTML = "";

        cards.forEach(function(card) {
            cardContainer.appendChild(card);
        });

        currentSort = 'name'; // Update the current sorting order

        searchBooks(); // Reapply the search filter
    }

    function sortByPrice() {
        var cards = Array.from(document.getElementsByClassName("col"));

        cards.sort(function(a, b) {
            var priceA = parseFloat(a.querySelector(".card-price").innerText);
            var priceB = parseFloat(b.querySelector(".card-price").innerText);
            return priceA - priceB;
        });

        var cardContainer = document.getElementById("cardContainer");
        cardContainer.innerHTML = "";

        cards.forEach(function(card) {
            cardContainer.appendChild(card);
        });

        currentSort = 'price'; // Update the current sorting order

        searchBooks(); // Reapply the search filter
    }


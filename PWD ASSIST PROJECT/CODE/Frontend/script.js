// PWD Assist - navigation at directory search lang
// Walang form, walang database, at walang API.
// Static lang lahat, kaya kahit walang server gumagana pa rin.

// ===== PAGE NAVIGATION =====
var navButtons = document.querySelectorAll(".nav-link");
var pages = document.querySelectorAll(".page");
var goButtons = document.querySelectorAll("[data-go]");

// ginagamit para hindi na mag animate kung gusto ng user na walang motion
var reduceMotion = window.matchMedia("(prefers-reduced-motion: reduce)").matches;

// Function to show a specific page and hide the others
function showPage(pageId) {
  for (var i = 0; i < pages.length; i++) {
    if (pages[i].id === pageId) {
      pages[i].classList.add("active");
    } else {
      pages[i].classList.remove("active");
    }
  }

  // update the active state on the sidebar buttons
  for (var i = 0; i < navButtons.length; i++) {
    if (navButtons[i].getAttribute("data-page") === pageId) {
      navButtons[i].classList.add("active");
      navButtons[i].setAttribute("aria-current", "page");
    } else {
      navButtons[i].classList.remove("active");
      navButtons[i].removeAttribute("aria-current");
    }
  }

  // ilipat ang focus sa title ng page para sa screen reader users
  var page = document.getElementById(pageId);
  var heading = page ? page.querySelector("h2") : null;

  if (heading) {
    heading.setAttribute("tabindex", "-1");
    heading.focus({ preventScroll: true });
  }

  window.scrollTo({
    top: 0,
    behavior: reduceMotion ? "auto" : "smooth"
  });
}

// Add click events to the sidebar navigation buttons
for (var i = 0; i < navButtons.length; i++) {
  navButtons[i].addEventListener("click", function () {
    var pageId = this.getAttribute("data-page");
    showPage(pageId);
  });
}

// Add click events to the feature card buttons (home page shortcuts)
for (var i = 0; i < goButtons.length; i++) {
  goButtons[i].addEventListener("click", function () {
    var pageId = this.getAttribute("data-go");
    showPage(pageId);
  });
}


// ===== DIRECTORY SEARCH AND FILTER =====
var searchInput = document.getElementById("directorySearch");
var filterButtons = document.querySelectorAll(".filter-button");
var directoryList = document.getElementById("directoryList");
var directoryCards = document.querySelectorAll(".directory-card");
var directoryStatus = document.getElementById("directoryStatus");

// Track which category filter is currently selected
var selectedCategory = "All";

// Function to filter directory cards based on category and search text
function filterDirectory() {
  var searchText = searchInput.value.toLowerCase().trim();
  var visibleCount = 0;

  for (var i = 0; i < directoryCards.length; i++) {
    var card = directoryCards[i];
    var category = card.getAttribute("data-category");
    var cardText = card.textContent.toLowerCase();

    var matchesCategory = (selectedCategory === "All") || (category === selectedCategory);
    var matchesSearch = cardText.indexOf(searchText) !== -1;

    if (matchesCategory && matchesSearch) {
      card.style.display = "flex";
      visibleCount++;
    } else {
      card.style.display = "none";
    }
  }

  // Remove old "no results" message if it exists
  var oldMessage = directoryList.querySelector(".empty-state");
  if (oldMessage) {
    directoryList.removeChild(oldMessage);
  }

  if (visibleCount === 0) {
    var message = document.createElement("p");
    message.className = "empty-state";
    message.textContent = "No directory results found. Try another search.";
    directoryList.appendChild(message);
  }

  // para malaman ng screen reader kung ilan ang lumabas
  var word = visibleCount === 1 ? "result" : "results";
  directoryStatus.textContent = visibleCount + " " + word + " found.";
}

// Listen for typing in the search box
searchInput.addEventListener("input", filterDirectory);

// Add click events to the filter buttons
for (var i = 0; i < filterButtons.length; i++) {
  filterButtons[i].addEventListener("click", function () {
    selectedCategory = this.getAttribute("data-filter");

    for (var j = 0; j < filterButtons.length; j++) {
      filterButtons[j].classList.remove("selected");
      filterButtons[j].setAttribute("aria-pressed", "false");
    }

    this.classList.add("selected");
    this.setAttribute("aria-pressed", "true");

    filterDirectory();
  });
}

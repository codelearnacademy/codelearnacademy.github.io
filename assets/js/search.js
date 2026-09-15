(function () {
  const input = document.getElementById("cla-search-input");
  const results = document.getElementById("cla-search-results");

  if (!input || !results) return;

  const indexUrl = input.dataset.searchIndex || "search.json";
  let documents = [];

  function normalize(value) {
    return String(value || "")
      .toLowerCase()
      .normalize("NFD")
      .replace(/[\u0300-\u036f]/g, "");
  }

  function scoreDocument(doc, terms) {
    const title = normalize(doc.title);
    const description = normalize(doc.description);
    const content = normalize(doc.content);
    const url = normalize(doc.url);
    let score = 0;

    for (const term of terms) {
      if (title.includes(term)) score += 10;
      if (description.includes(term)) score += 5;
      if (url.includes(term)) score += 3;
      if (content.includes(term)) score += 1;
    }

    return score;
  }

  function escapeHtml(value) {
    return String(value || "")
      .replace(/&/g, "&amp;")
      .replace(/</g, "&lt;")
      .replace(/>/g, "&gt;")
      .replace(/"/g, "&quot;")
      .replace(/'/g, "&#039;");
  }

  function render(matches) {
    if (!matches.length) {
      results.innerHTML = "<div class='cla-search-empty'>Sin resultados</div>";
      results.classList.add("is-open");
      return;
    }

    results.innerHTML = matches.slice(0, 8).map(doc => `
      <a href="${escapeHtml(doc.url)}">
        <strong>${escapeHtml(doc.title)}</strong>
        <span>${escapeHtml(doc.description || doc.url)}</span>
      </a>
    `).join("");

    results.classList.add("is-open");
  }

  fetch(indexUrl)
    .then(response => response.ok ? response.json() : [])
    .then(data => { documents = Array.isArray(data) ? data.filter(doc => doc.title && doc.url) : []; })
    .catch(() => { documents = []; });

  input.addEventListener("input", function () {
    const query = normalize(input.value.trim());

    if (query.length < 2) {
      results.classList.remove("is-open");
      results.innerHTML = "";
      return;
    }

    const terms = query.split(/\s+/).filter(Boolean);
    const matches = documents
      .map(doc => ({ ...doc, _score: scoreDocument(doc, terms) }))
      .filter(doc => doc._score > 0)
      .sort((a, b) => b._score - a._score);

    render(matches);
  });

  input.addEventListener("focus", function () {
    if (input.value.trim().length >= 2 && results.innerHTML.trim()) results.classList.add("is-open");
  });

  document.addEventListener("click", function (event) {
    if (!event.target.closest(".cla-search")) results.classList.remove("is-open");
  });
})();

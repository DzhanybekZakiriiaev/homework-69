<!DOCTYPE html>
<html lang="${.lang}">
<#import "/spring.ftl" as spring>
<head>
    <meta charset="UTF-8">
    <title><@spring.message "title"/></title>
    <link rel="stylesheet" type="text/css" href="../main.css">
    <script src="../script.js"></script>
</head>
<body>
<div class="container">
    <form action="" method="get">
        <label for="lang_select">
            <@spring.message "language"/>:
        </label>
        <select name="lang" id="lang_select">
            <option value="en">English</option>
            <option value="ru">Russian</option>
        </select>
        <button type="submit">
            <@spring.message "choose" />
        </button>
    </form>

    <div id="main">
        <div id="left-column">
            <form id="list-form">
                <label for="list1"></label>
                <div id="dropdown1">
                    <button id="drop-btn1" class="btn-dropdown"><@spring.message "title"/></button>
                    <div id="list1">
                        <a href="#">Intel</a>
                        <a href="#">AMD</a>
                    </div>
                </div>
                <br>
                <label for="list2"></label>
                <div id="dropdown2">
                    <button id="drop-btn2" class="btn-dropdown"><@spring.message "motherboards"/></button>
                    <div id="list2">
                        <a href="#">Gigabyte</a>
                        <a href="#">Asus</a>
                        <a href="#">Intel</a>
                        <a href="#">MSI</a>
                        <a href="#">ASRock</a>
                    </div>
                </div>
                <br>
                <label for="list3"></label>
                <div id="dropdown3">
                    <button id="drop-btn3" class="btn-dropdown"><@spring.message "cooling_systems"/></button>
                    <div id="list3">
                        <a href="#">DEEPCOOL</a>
                        <a href="#">Asus</a>
                        <a href="#">Arctic</a>
                    </div>
                </div>
                <br>
                <label for="list4"></label>
                <div id="dropdown4">
                    <button id="drop-btn4" class="btn-dropdown"><@spring.message "ram"/></button>
                    <div id="list4">
                        <a href="#">Kingston</a>
                        <a href="#">Gigabyte</a>
                        <a href="#">AMD</a>
                        <a href="#">HyperX</a>
                    </div>
                </div>
                <br>
                <label for="list5"></label>
                <div id="dropdown5">
                    <button id="drop-btn5" class="btn-dropdown"><@spring.message "graphics_cards"/></button>
                    <div id="list5">
                        <a href="#">Asus</a>
                        <a href="#">Gigabyte</a>
                        <a href="#">MSI</a>
                        <a href="#">HP</a>
                    </div>
                </div>
                <br>
                <label for="list6"></label>
                <div id="dropdown6">
                    <button id="drop-btn6" class="btn-dropdown"><@spring.message "hard_drives"/></button>
                    <div id="list6">
                        <a href="#">Toshiba</a>
                        <a href="#">WD</a>
                        <a href="#">Seagate</a>
                        <a href="#">Samsung</a>
                    </div>
                </div>
                <br>
                <label for="list7"></label>
                <div id="dropdown7">
                    <button id="drop-btn7" class="btn-dropdown"><@spring.message "power_supplies"/></button>
                    <div id="list7">
                        <a href="#">Vinga</a>
                        <a href="#">AeroCool</a>
                        <a href="#">Deepcool</a>
                        <a href="#">Zalman</a>
                    </div>
                </div>
                <br>
                <label for="list8"></label>
                <div id="dropdown8">
                    <button id="drop-btn8" class="btn-dropdown"><@spring.message "cases"/></button>
                    <div id="list8">
                        <a href="#">Zalman</a>
                        <a href="#">Corsair</a>
                        <a href="#">Cooler Master</a>
                        <a href="#">Chieftec</a>
                    </div>
                </div>
                <!-- CSRF Token -->
                <input type="hidden" name="_token" value="YOUR_CSRF_TOKEN_HERE">
            </form>
        </div>
        <div id="content">
            <div class="switch-start" style="display: flex">
                <button class="prev" type="button" style="display: flex"><@spring.message "previous_page"/></button>
                <button class="next" type="button" style="display: flex"><@spring.message "next_page"/></button>
            </div>
            <div class="switch-start-brand" style="display: none">
                <button id="prev" type="button" style="display: flex"><@spring.message "previous_page"/></button>
                <button id="next" type="button" style="display: flex"><@spring.message "next_page"/></button>
            </div>
            <div id="content-products">

            </div>
        </div>
        <div id="right-column">
            <div class="search-right-col">
                <form id="search-form-page">
                    <input type="hidden" name="_token" value="YOUR_CSRF_TOKEN_HERE">
                    <label>
                        <input name="s" placeholder="<@spring.message "search"/>" type="search" id="search-input">
                        <input name="h" value="0" hidden id="search-input-hidden">
                    </label>
                    <button type="submit" id="search-button"><@spring.message "search_button"/></button>
                </form>
            </div>
            <div class="dropdown">
                <button class="dropbtn"><@spring.message "advanced_search"/></button>
                <div class="dropdown-content">
                    <form id="search-form-hidden">
                        <!-- CSRF Token -->
                        <input type="hidden" name="_token" value="YOUR_CSRF_TOKEN_HERE">
                        <label>
                            <p><@spring.message "search_by_brand"/></p>
                            <input name="s" placeholder="<@spring.message "search_by_brand"/>" type="search" id="search-input-hidden">
                            <input name="h" value="0" hidden id="hidden-search-input">
                            <p><@spring.message "search_by_description"/></p>
                            <input name="d" placeholder="<@spring.message "search_by_description"/>" type="search" id="search-input-description">
                            <p><@spring.message "price_range"/></p>
                            <input name="min" placeholder="<@spring.message "min_price"/>" type="search" id="min-search-input">
                            <input name="max" placeholder="<@spring.message "max_price"/>" type="search" id="max-search-input">
                        </label>
                        <button type="submit" id="search-button-brand"><@spring.message "search_button"/></button>
                    </form>
                </div>
            </div>
            <div class="orders">
                <h3 id="orders-title"><@spring.message "your_cart"/></h3>
                <div id="orders-list">
                    <ol id="orders-ol">
                        <li id="clear-li-text"><@spring.message "cart_empty"/></li>
                    </ol>
                </div>
                <a href="#">
                    <button type="button" id="orders-button"><@spring.message "go_to_cart"/></button>
                </a>
                <button type="button" id="orders-button-clear"><@spring.message "clear_cart"/></button>
            </div>
        </div>
    </div>
</div>
</body>
</html>

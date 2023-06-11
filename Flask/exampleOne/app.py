from flask import Flask, render_template, request
import datetime

app = Flask(__name__)


@app.route("/")
def index():
    return render_template("index.html")


@app.route("/greet", methods=["POST"])  # supports "get" by default, but not "post"
def greet():
    name = request.form.get("name")
    world = "world"
    date_now = datetime.datetime.now()
    return render_template("greet.html", name=name, world=world, date_now=date_now)


# E.g.
# http://127.0.0.1:5000/?name=Bradley
# http://127.0.0.1:5000/?name=Michael

# Model->View->User->Controller->Model repeats, framework/model

from flask import Flask, render_template, request
import datetime

app = Flask(__name__)


@app.route("/")
def index():
    return render_template("index.html")


@app.route("/greet")
def greet():
    name = request.args.get("name")
    date_now = datetime.datetime.now()
    return render_template("greet.html", name=name, date_now=date_now)


# E.g.
# http://127.0.0.1:5000/?name=Bradley
# http://127.0.0.1:5000/?name=Michael

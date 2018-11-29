from flask import Flask,request,Response
from flask_restful import Resource, Api
import json
import sys

app = Flask(__name__)
api = Api(app)
board = {'foo' : 20,'bar': 30,"joh": 26,"har": 28}

class Game(Resource):

	def get(self):
		data = ""
		for key in board:
			data += '{:8s}:{:2s}s;'.format(key, str(board[key]))
			#data += key+" : "+str(board[key])+"s;"
		return Response(response=data,status=200)

	def post(self):
		user_name = request.json['username']
		score = int(request.json['score'])
		board[user_name] = score
		#print('done')
		return Response(status=201)

api.add_resource(Game,"/scoreboard")

def start_server(port):
	try:
		app.run(debug=True,host= '0.0.0.0',port=port)
	except:
		print("handling error")

if __name__ == '__main__':
	port = sys.argv[1]
	start_server(port)
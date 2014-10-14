#!/usr/bin/env bash

# add repository
echo 'deb http://www.rabbitmq.com/debian/ testing main' | sudo tee -a /etc/apt/sources.list
wget http://www.rabbitmq.com/rabbitmq-signing-key-public.asc
sudo apt-key add rabbitmq-signing-key-public.asc

sudo apt-get update

sudo mkdir -p /etc/rabbitmq
echo '[{rabbit, [{loopback_users, []}]}].' | sudo tee -a /etc/rabbitmq/rabbitmq.config

# install rabbitmq
sudo apt-get -y install rabbitmq-server




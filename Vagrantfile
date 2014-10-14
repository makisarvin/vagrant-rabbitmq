# -*- mode: ruby -*-
# vi: set ft=ruby :

# Vagrantfile API/syntax version. Don't touch unless you know what you're doing!
VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  if Vagrant.has_plugin?("vagrant-proxyconf")
    config.proxy.http     = "http://<user>:<password>@<ip>:<port>"
    config.proxy.https    = "http://<user>:<password>@<ip>:<port>"
    config.proxy.no_proxy = "localhost,127.0.0.1,.example.com"
  end

  config.vm.define :rabbitmq do |x|
    x.vm.box = "hashicorp/precise64"
    x.vm.provision :shell, path: "bootstrap.sh"
    x.vm.hostname = "rabbitmq"
    x.vm.network "private_network", ip: "10.0.0.1"
    x.vm.network :forwarded_port, host: 5672, guest: 5672
  end
end
